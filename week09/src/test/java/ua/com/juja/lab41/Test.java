package ua.com.juja.lab41;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List list = new LinkedList();

        Integer[] listElements = {1, 2, 3, 4, 5, 6, 7};
        Integer[] expectedElements = {1, 1, 2, 3, 4, 5, 6};

        SimpleLinkedList<Integer> arrayList = new SimpleLinkedList<>();

        for (int i = 0; i < listElements.length; i++) {
            arrayList.add(listElements[i]);
        }

        System.out.println(arrayList.toString());
        arrayList.remove(4);
//        System.out.println(arrayList.toString());


        Iterator itr = arrayList.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println(arrayList.equals(expectedElements));

        System.out.print("OK");
    }
}