package ua.com.juja.lab42;

public class Test {
    public static void main(String[] args) {

        Integer[] arr = {7, 6, 5, 4, 3, 2, 1};
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        System.out.println(FinderElements.findElement(list, 3));
    }
}
