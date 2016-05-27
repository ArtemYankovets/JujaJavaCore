package ua.com.juja.lab40;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<E> implements SimpleList<E> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public SimpleArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public SimpleArrayList(int initialCapacity) {
        this.data = (E[]) new Object[initialCapacity];
    }

    @Override
    public boolean add(E newElement) {
        ensureCapacity(size + 1);
        data[size] = newElement;
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return data[index];
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
        rangeCheck(index);
        E oldValue = data[index];
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
        return oldValue;
    }

    private void rangeCheck(int index) {
        if (index < 0 || size < index) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(minCapacity, data.length + (data.length >> 1));
            E[] newData = (E[]) new Object[newCapacity];
            System.arraycopy(data, 0, newData, 0, data.length);
            this.data = newData;
        }
    }

    /*BODY*/
    public String toString() {
        String rez = "[";
        for (int i = 0; i < size(); i++) {
            if (i != size-1) {
                rez += get(i) + ", ";
            } else {
                rez += get(i);
            }
        }
        return rez + "]";
    }

    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null) return false;

        SimpleArrayList<E> tmp;
        if (!(o instanceof SimpleArrayList)) return false;

        tmp = ((SimpleArrayList<E>) o);
        if (this.size() != tmp.size()) return false;

        boolean f = true;
        for (int i = 0; i < size; i++) {
            if (tmp.get(i) != this.get(i)) {
                f = false;
                break;
            }
        }
        return f;
    }

    public int hashCode() {
        int hashCode = 1;
        for (E e : data) {
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        }
        return hashCode;
    }

    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator<E> implements Iterator<E> {

        private int cursor;
        private int lastRet;

        public ArrayListIterator() {
            this.cursor = 0;
            this.lastRet = -1;
        }

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            int i = cursor;
            if (i >= size()) {
                throw new NoSuchElementException();
            }
            cursor = i + 1;
            return (E) SimpleArrayList.this.get(lastRet = i);
        }

        @Override
        public void remove() {
            if (lastRet < 0) {
                throw new IllegalStateException();
            }
            SimpleArrayList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;
        }
    }
}

interface SimpleList<E> {
    public boolean add(E newElement);

    public E get(int index);

    public Iterator<E> iterator();

    public int size();

    public boolean isEmpty();

    public E remove(int index);
}