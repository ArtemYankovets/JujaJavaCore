package ua.com.juja.algorithms;

public class RecursiveCoinsChanger {
    private static final int[] COIN_NOMINALS = new int[]{1, 2, 5, 10, 25, 50};

    public static void main(String[] args) {
        System.out.println(calcVariants(5));
        System.out.println(calcVariants(10));
        System.out.println(calcVariants(100));
    }

    private static int calcVariants(int cashValue) {
        return findCombination(COIN_NOMINALS.length - 1, cashValue, new int[COIN_NOMINALS.length]);
    }

    private static int findCombination(int nominalIndex, int cashValue, int[] combinations) {
        int sum = 0;
        int variantsCount = 0;
        /*while (sum < cashValue) {
            if (nominalIndex > 0) {
                variantsCount += findCombination(nominalIndex - 1, cashValue, combinations);
                clearLowNominalsCount(nominalIndex, combinations);
            }
            combinations[nominalIndex]++;
            sum = calcSum(combinations);
            if (sum == cashValue) {
                variantsCount++;
            }
        }*/
        return sum;
    }


}
