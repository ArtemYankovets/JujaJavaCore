package ua.com.juja.arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Artem on 05.04.2016.
 */
public class InsertionSort {
    public static void main(String[] args) {
//        int size = 256 * 1024;
//
//        int[] array = arrayFill(size);
//        int[] arraySlow = new int[size];
//        System.arraycopy(array, 0, arraySlow, 0, array.length);
//
        int[] array = {-1, -2, 1, 0, 4, 5, -1, 3, 2};
        int[] arraySlow = new int[array.length];
        System.arraycopy(array, 0, arraySlow, 0, array.length);

//        int[] array3 = {1, 2, 4, 5, 6};
//        int ind = Arrays.binarySearch(array3, 0, 3, 3);
//        System.out.println(ind);
//        int[] array2 = {0, 0, 0, 0, 0, 0, 0};
//        System.arraycopy(array, 2, array2, 2, 3);
//
//        System.out.println(Arrays.toString(array2));

        System.out.println(Arrays.toString(array));
        long t1 = System.nanoTime();
        sort(array);
        System.out.println("A:" + (System.nanoTime() - t1) / 1_000_000);

        System.out.println(Arrays.toString(array));
        long t2 = System.nanoTime();
        sortSlow(arraySlow);
        System.out.println("A:" + (System.nanoTime() - t2) / 1_000_000);
        System.out.println(Arrays.toString(array));

    }

    public static void sort(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int lastIndex = k - 1;
            if (newElement < arr[lastIndex]){
                int position = java.util.Arrays.binarySearch(arr, 0, lastIndex, newElement);
                if (position < 0) {
                    position = (-1) * (position + 1);
                    System.arraycopy(arr, position, arr, position + 1, (k - position));
                    arr[position] = newElement;
                } else {
                    System.arraycopy(arr, position, arr, position + 1, (k - position));
                    arr[position] = newElement;
                }
            } else {
                //Do nothing
            }
        }
    }

    public static void sortSlow(int[] arr) {
        for (int k = 1; k < arr.length; k++) {
            int newElement = arr[k];
            int location = k - 1;
            while (location >= 0 && arr[location] > newElement) {
                arr[location + 1] = arr[location];
                location--;
            }
            arr[location + 1] = newElement;
        }
    }

    public static int[] arrayFill(int size){
        int[] array = new int[size];
        Random rnd = new Random(0);
        for (int k = 0; k < array.length; k++) {
            array[k] = rnd.nextInt();
        }
        return array;
    }
}
