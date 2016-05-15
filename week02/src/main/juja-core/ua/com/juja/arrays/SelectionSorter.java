package ua.com.juja.arrays;

/**
 * Created by Artem on 04.04.2016.
 */
public class SelectionSorter {
    public static void main(String[] args) {
        int[] array = {1, 0, 4, 5, -1, 3, 2};
        printArray(array);
        sort(array);
        printArray(array);
    }

    public static void sort(int[] arr) {
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            int min = barrier;
            for (int index = barrier + 1; index < arr.length; index++) {
                if (arr[min] > arr[index]){
                    min = index;
                }
            }
            if (arr[barrier] > arr[min]) {
                int tmp = arr[min];
                arr[min] = arr[barrier];
                arr[barrier] = tmp;
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


