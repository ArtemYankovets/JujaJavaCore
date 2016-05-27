package ua.com.juja.lab41;

import java.util.*;


public class Test3 {
    public static void main(String[] args) {

        // list is one element
        Integer[] expectedElements = {1, 2, 3, 4, 5, 6, 7};

        SimpleLinkedList<Integer> simpleLinkedList = new SimpleLinkedList<>();

        for (int i = 0; i < expectedElements.length; i++) {
            simpleLinkedList.add(expectedElements[i]);
        }

        //My option
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < expectedElements.length; i++) {
            list.add(expectedElements[i]);
        }

        //call and check
        Iterator<Integer> iterator = null;
        Iterator<Integer> itr = null;

        try {
            iterator = simpleLinkedList.iterator();
            itr = list.iterator();
        } catch (UnsupportedOperationException u) {
            throw new AssertionError("Iterator not implemented");
        }

        if (iterator == null)
            throw new AssertionError("Iterator must be no equals null");

        // call before get element
        if (!iterator.hasNext())
            throw new AssertionError("hasNext() must be returned true if list is not empty");

        boolean isExceptionMethodNext = false;
        Integer[] actualElements = new Integer[expectedElements.length];

        try {
            int i = 0;
            while (iterator.hasNext()) {
                if (i < actualElements.length)
                    actualElements[i++] = iterator.next();
                else
                    throw new AssertionError("length actual data more  length expected data");
            }

        } catch (NoSuchElementException e) {
            isExceptionMethodNext = true;
        }

        isExceptionMethodNext = false;
        Integer[] actualElementsMy = new Integer[expectedElements.length];
        try {
            int i = 0;
            while (itr.hasNext()) {
                if (i < actualElementsMy.length)
                    actualElementsMy[i++] = itr.next();
                else
                    throw new AssertionError("length actual data more  length expected data");
            }

        } catch (NoSuchElementException e) {
            isExceptionMethodNext = true;
        }

        for (int i = 0; i < actualElementsMy.length; i++) {
            System.out.print(actualElementsMy[i]+ " ");
        }

        System.out.println();
        for (int i = 0; i < actualElements.length; i++) {
            System.out.print(actualElements[i]+ " ");
        }

        if (isExceptionMethodNext)
            throw new AssertionError("next() throw NoSuchElementException when list is not empty");

        if (!Arrays.equals(actualElements, expectedElements))
            throw new AssertionError("actual data is not equal to expected data");


        System.out.print("OK");
    }
}