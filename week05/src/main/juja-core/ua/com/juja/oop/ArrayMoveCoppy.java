package ua.com.juja.oop;

import java.util.Arrays;

public class ArrayMoveCoppy {
    private static int indexShipInPort = 8;
    private static int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {


        for (int i = 0; i < 9; i++) {
            if (removeFirstItem() == 1){
                System.out.println(i + " " + Arrays.toString(arr));
            } else {
                System.out.println("Error");
            }
        }
    }

    private static int removeFirstItem() {
        if (arr[0] == 0) {
            return -1;
        } else {
            if (arr[1] == 0){
                arr[0] = 0;
                indexShipInPort--;
                return 1;
            } else{
                System.arraycopy(arr, 1, arr, 0, indexShipInPort);
                arr[indexShipInPort] = 0;
                indexShipInPort--;
                return 1;
            }
        }
    }
}
