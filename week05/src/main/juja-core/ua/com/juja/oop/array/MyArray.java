package ua.com.juja.oop.array;

import java.util.Arrays;

// SOLID    1. Single responsebility 2. Open-close 3. Liskov substitution
// RCSLI    4. Interface segregation 5. Dependency inversion
// PPPPP

public class MyArray {
    private int[] data;

    public MyArray() {
        this.data = new int[0];
    }

    public MyArray(int length) {
        this.data = new int[length];
    }

    public MyArray(MyArray sourse) {
        data = new int[sourse.data.length + 1];
        for (int i = 0; i < sourse.data.length; i++) {
            data[i] = sourse.data[i];
        }
    }

    //CreateReadUpdateDelete

    public int get(int index) {
        return data[index];
    }

    public void change(int index, int newValue) {
        data[index] = newValue;
    }

    public void remove(int index) {
        int[] array2 = new int[data.length - 1];
        for (int i = 0; i < index; i++) {
            array2[i] = data[i];
        }
        for (int i = index + 1; i < data.length; i++) {
            array2[i - 1] = data[i];
        }
        data = array2;
    }

    public void add(int index, int newValue){
        int[] array2 = new int[data.length + 1];
        for (int i = 0; i < index; i++) {
            array2[i] = data[i];
        }
        array2[index] = newValue;
        for (int i = index; i < data.length; i++) {
            array2[i + 1] = data[i];
        }
        data = array2;
    }

    public MyArray copy(){
        return new MyArray(this);
    }

    public int size() {
        return data.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(data);
    }

    public void add(int newValue) {
        add(data.length, newValue);
    }
}
