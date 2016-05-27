package ua.com.juja.lab41;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class SimpleLinkedList<E> implements SimpleList<E> {
    private Node<E> first = null; // head
    private Node<E> last = null; // tail
    private int size = 0;

    private static class Node<T> {
        private Node<T> prev;
        private T item;
        private Node<T> next;

        private Node(Node<T> prev, T item, Node<T> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }

//        public String toString(){
//            return this.item.toString();
//        }
    }

    private void checkIndex(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private Node<E> node(int index) {
        if (index < size / 2) {
            Node<E> tmp = first;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            return tmp;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    private E unlink(Node<E> x) { //todo:
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    @Override
    public boolean add(E newElement) {
        final Node<E> tmp = last;
        final Node<E> newNode = new Node<>(tmp, newElement, null);
        last = newNode;
        if (tmp == null) {
            first = newNode;
        } else {
            tmp.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return node(index).item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        return unlink(node(index));
    }

    /*BODY*/
//Task 1 - method iterator()
    public Iterator<E> iterator() {
        return new MyLinkedListIterator<E>();
    }

    private class MyLinkedListIterator<E> implements Iterator<E> {
        private Node curr;
        private boolean removed;
        private int nextIndex;

        public MyLinkedListIterator() {
            this.curr = null;
            this.removed = false;
            this.nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return (curr == null && first != null) || (curr != null && curr.next != null);
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            removed = false;
            if (curr == null) {
                curr = first;
                return (E) curr.item;
            } else {
                curr = curr.next;
                return (E)curr.item;
            }


//            if (curr != null){
//                E tmp = (E) curr.item;
//                curr = curr.next;
//                nextIndex++;
//                return tmp;
//            } else {
//                curr = first;
//                return (E) curr.item;
//            }
        }

        @Override
        public void remove() {
            if (!removed || curr == null) {
                throw new IllegalStateException();
            }
            if (curr == first) {
                first = curr.next;
            } else{
                Node next = curr.next;
                curr = curr.prev;
                curr.next = next;
            }
            removed = true;
        }
    }

//Task 2 - method toString()
    @Override
    public String toString() {
        String rez = "[";
        Node<E> elem;
        if (first != null) {
            elem = first;

            while (elem != null){
                if (elem.next == null){
                    rez += elem.item;
                } else {
                    rez += elem.item + ", ";
                }
                elem = elem.next;
            }
        }
        return rez + "]";
    }

//Task 3 and 4 - method equals() and hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;
        SimpleLinkedList<E> tmp = (SimpleLinkedList<E>) o;

        if (size() != tmp.size()) return false;

        Iterator itr = this.iterator();
        Iterator itrTmp = tmp.iterator();

        while (itr.hasNext()){
            if (itr.next() != itrTmp.next()){
                return false;
            }
        }

//        for (int i = 0; i < size; i++) {
//            if (tmp.get(i) != this.get(i)) {
//                return false;
//            }
//        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        Iterator itr = SimpleLinkedList.this.iterator();
        while (itr.hasNext()) {
            hashCode = 31 * hashCode + (itr.next() == null ? 0 : itr.next().hashCode());
        }
        return hashCode;
    }
}

interface SimpleList<T> {
    public boolean add(T newElement);

    public T get(int index);

    public Iterator<T> iterator();

    public int size();

    public boolean isEmpty();

    public T remove(int index);
}