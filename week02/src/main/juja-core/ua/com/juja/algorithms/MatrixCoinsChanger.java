package ua.com.juja.algorithms;

/**
 * Created by Artem on 10.04.2016.
 */

public class MatrixCoinsChanger {

    private static final int[] COIN_NOMINALS = new int[]{1, 2, 5, 10, 25, 50};

    public static void main(String[] args) {
        System.out.println(getCombinations(5));
        System.out.println(getCombinations(10));
        System.out.println(getCombinations(100));
    }

    public static int getCombinations(int sum) {
        if (sum <= 0) return 0;

        int num = COIN_NOMINALS.length;
        int cache[][] = new int [sum + 1][num];
        int variantsWithCurrentNominalCount;
        int previousNominalsVariantCount;

        for (int i = 0; i < num; i++) {
            cache[0][i] = 1;
        }

        for (int i = 1; i < sum + 1; i++) {
            for (int j = 0; j < num; j++) {
                int currentSum = i - COIN_NOMINALS[j];

                if (currentSum >= 0){
                    variantsWithCurrentNominalCount = cache[currentSum][j];
                } else {
                    variantsWithCurrentNominalCount = 0;
                }

                if (j >= 1) {
                    previousNominalsVariantCount = cache[i][j - 1];
                } else {
                    previousNominalsVariantCount = 0;
                }

                cache[i][j] = variantsWithCurrentNominalCount + previousNominalsVariantCount;
            }
        }
        return cache[sum][num - 1];
    }
}
