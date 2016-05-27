package ua.com.juja.lab42;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SinglyLinkedListTest {

    @Test
    public void test() {
        Integer[] expectedElements = {7, 6, 5, 4, 3, 2, 1};
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        for (int i = 0; i < expectedElements.length; i++) {
            list.add(expectedElements[i]);
        }

        Integer actuals = FinderElements.findElement(list,3);      //3 elem from the end of list
        Integer expected = 4;

        assertEquals(expected, actuals);
    }
}
