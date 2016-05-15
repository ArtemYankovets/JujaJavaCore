package ua.com.juja.oop;

public class SortArr {
    public static int[] arr = new int[]{5, 2, 1, 3, 1};

    public static void main(String[] args) {
        String s = "";
        for (int i = 0; i < arr.length ; i++) {
            for (int j = arr.length - 1 ; j > i; j--) {
                if (arr[j] < arr[j-1]) {
                    int tmp = arr[j - 1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
            s += arr[i] + " ";
        }

        System.out.println(s);
    }
}
