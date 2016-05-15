package ua.com.juja.arrays;

/**
 * Created by Artem on 04.04.2016.
 */
public class BubbleSorter {
    public static void main(String[] args) {
        int[] array = {5, 3, 4, 6, 2, 0, 1};
        printArray(array);
        sort(array);
        printArray(array);
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = arr.length-1; j > i ; j--) {
                if (arr[j] < arr[j-1]){
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    public static void printArray(int[] arr){
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
