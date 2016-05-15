package ua.com.juja.matrix;

/**
 * Created by Artem on 11.04.2016.
 */
public class MatrixMultuple {
    public static void main(String[] args) {
        int firstMatrix[][] = new int[][]{{1 , 2}, {7, 8}, {3, 4}};
        int secondMatrix[][] = new int[][]{{3, 4, 5, 6}, {9, 0, 1, 2}};
        System.out.println("This is the first matrix");
        matrixPrint(firstMatrix);

        System.out.println("This is the second matrix");
        matrixPrint(secondMatrix);

        System.out.println("This is the multipled matrix");
        matrixPrint(mul(firstMatrix, secondMatrix));
    }

    public static int[][] mul(int[][] fst, int[][] snd) {

        int fstRows = fst.length;
        int fstCols = fst[0].length;
        int sndRows = snd.length;
        int sndCols = snd[0].length;

        if (fstCols != sndRows) {
            throw new IllegalArgumentException("matrices don't match: " + fstCols + " != " + sndRows);
        }
        else {
            int[][] multipledMatrix = new int[fstRows][sndCols];

            for (int i=0; i< fstRows; i++){
                for (int j=0; j< sndCols; j++){
                    for (int k=0; k< fstCols; k++){
                        multipledMatrix[i][j] += fst[i][k] * snd[k][j];
                    }
                }
            }
            return multipledMatrix;
        }
    }

    public static void matrixPrint(int[][] matrix){
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
