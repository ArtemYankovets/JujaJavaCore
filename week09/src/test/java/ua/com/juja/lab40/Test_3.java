package ua.com.juja.lab40;

public class Test_3 {
    public static void main(String[] args) {
        Integer[] expectedElements = {1, 2, 3, 4, 5, 6, 7};
        String expectedPrintString = "[1, 2, 3, 4, 5, 6, 7]";

        SimpleArrayList<Integer> simpleArrayList = new SimpleArrayList<>();

        for (int i = 0; i < expectedElements.length; i++) {
            simpleArrayList.add(expectedElements[i]);
        }

        //call

        String actualPrintString = simpleArrayList.toString();

        //check
        if (!expectedPrintString.equals(actualPrintString))
            throw new AssertionError("Should be printed " + expectedPrintString + " but printed " + actualPrintString);

        System.out.print("OK");
    }
}