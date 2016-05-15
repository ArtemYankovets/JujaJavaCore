package ua.com.juja.algorithms;

public class MatrixCoinsChanger2 {

    private static final int[] COIN_NOMINALS = new int[]{1, 2, 5, 10, 25, 50};

    public static void main(String[] args) {
        System.out.println(getCombinations(5));
    }

    /*
     *  разменять N-ку монетками a0, a1, a2, a3, ... , am =
     *  количество комбинаций как разменять N-ку монетками a0...a(m-1)
     *      при условии, что m > 0
     *  +
     *  количество комбинаций, как разменять (N-ку - текущий номинал am)
     *      при условии, что разница больше = 0
     */
    public static int getCombinations(int sum) {
        if (sum <= 0) return 0;

        int nominalsCount = COIN_NOMINALS.length;
        int combinations[][] = new int [sum + 1][nominalsCount];

        for (int i = 0; i < nominalsCount; i++) {
            combinations[0][i] = 1; //TODO WTF?
        }

        for (int number = 1; number <= sum; number++) {
            for (int nominalIndex = 0; nominalIndex < nominalsCount; nominalIndex++) {


                int current = 0;
                if (COIN_NOMINALS[nominalIndex] <= number){
                    int rest = number - COIN_NOMINALS[nominalIndex];
                    current = combinations[rest][nominalIndex]; // TODO cache[x][y] x-y WTF?
                }

                int previous = 0;
                if (nominalIndex >= 1) {
                    previous = combinations[number][nominalIndex - 1]; // TODO cache[x][y] x-y WTF?
                }

                combinations[number][nominalIndex] = current + previous;
//                debug(combinations, COIN_NOMINALS);
            }
        }
        return combinations[sum][nominalsCount - 1]; // TODO cache[x][y] x-y WTF?
    }

    private static void debug(int[][] cache, int[] coinNominals) {
        String result = "\t\t";

        for (int x = 0; x < coinNominals.length; x++) {
            result += coinNominals[x] + "\t";
        }
        result += '\n';

        for (int y = 0; y < cache.length; y++) {
            result += "[" + y + "] \t";
            for (int x = 0; x < coinNominals.length; x++) {
                result += cache[y][x] + "\t";
            }
            result += '\n';
        }
        System.out.println(result);
    }
}
