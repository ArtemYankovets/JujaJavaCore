package ua.com.juja.arrays;

/**
 * Created by Artem on 02.04.2016.
 */
public class ArrayInverter {

    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 4, 5};
//        invert(array);
//        printArray(array);
//
//        System.out.println();
//        int[] arrayOp = {1, 2, 3, 4, 5};
//        invertOp(arrayOp);
//        printArray(arrayOp);
//
//        System.out.println();
//        int[] arrayFiletr = {4, 3, 5, 6, 7, 9};
//        oddFilter(arrayFiletr);
//        printArray(arrayFiletr);
//
//        System.out.println();
//        int[] fst = {1, 3, 5, 7};
//        int[] snd = {2, 4, 6, 8};
//        int[] result = new int[fst.length + snd.length];
//        result = merge(fst, snd);
//        printArray(result);
//
//        System.out.println();
//        int[] arrayLookFor = {1, 1, 1};
//        int [] lookArray = new int[2];
//        lookArray = lookFor(arrayLookFor);
//        printArray(arrayLookFor);
//        System.out.println();
//        printArray(lookArray);

        System.out.println(lookForSollutions(14));
    }

    private static int lookForSollutions(int c) {

        int count = 0;
        for (int a = 1; a < c; a++) {
            for (int b = 1; b < c; b++) {
                if ((a*a + b*b) <= c) count++;
            }
        }
        return count;
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void invert(int[] arr) {
        for (int k = 0; k < arr.length / 2; k++) {
            int tmp = arr[k];
            arr[k] = arr[arr.length - k - 1];
            arr[arr.length - k - 1] = tmp;
        }
    }

    private static void invertOp(int[] arr) {
        if (arr.length > 1) {
            int k = ((arr.length) % 2 == 0) ? ((arr.length / 2) - 1) : (((arr.length) / 2) - 1);
            do {
                int tmp = arr[k];
                arr[k] = arr[arr.length - k - 1];
                arr[arr.length - k - 1] = tmp;
                k--;
            } while (k>=0);
        }
    }

    private static void oddFilter (int[] nums){
        if (nums.length > 0) {
            int i = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] % 2 == 0) {
                    if (i == j) {
                        i++;
                    } else {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        i++;
                    }
                } else {
                    nums[j] = 0;
                }
            }
        }
    }

    private static int[] merge (int[] fst, int[] snd){
        int[] result = new int[fst.length + snd.length];
        int fstIndex = 0;
        int sndIndex = 0;
        while (fstIndex + sndIndex != result.length) {
            if (fstIndex != fst.length && sndIndex!=snd.length) {
                if (fst[fstIndex] < snd[sndIndex]) {
                    result[fstIndex + sndIndex] = fst[fstIndex++];
                } else {
                    result[fstIndex + sndIndex] = snd[sndIndex++];
                }
            } else if (fstIndex != fst.length && sndIndex==snd.length){
                result[fstIndex + sndIndex] = fst[fstIndex++];
            } else {
                result[fstIndex + sndIndex] = snd[sndIndex++];
            }
        }
        return result;
    }

    public static int[] lookFor(int[] array) {
        int [] rez = {};
        int i = 0;
        boolean flag = true;
        while (i < array.length){
            if (array[i] > 0) {
                int firstIndex = i;
                while ((i<array.length) && (array[i]>0)) {
                   i++;
                }

                if (flag){
                    flag = false;
                    rez = new int[]{firstIndex, i - 1};
                } else {
                    if (((rez[1]+1) - rez[0]) <= (i - firstIndex)) {
                        rez = new int[]{firstIndex, i - 1};
                    }
                }
            } else {
                i++;
            }
        }
        return rez;
    }



}