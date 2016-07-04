package ua.com.juja.oop.array;

public class Main2 {
    public static void main(String[] args) {
        MyArray array = new MyArray();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);
        System.out.println(array.toString());

        array.remove(5);
        System.out.println(array.toString());

        array.add(3, 7);
        System.out.println(array.toString());
    }
}
