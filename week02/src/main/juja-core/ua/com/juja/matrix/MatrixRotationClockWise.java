package ua.com.juja.matrix;

/**
 * Created by Artem on 12.04.2016.
 */
public class MatrixRotationClockWise {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {0, 1},
                {2, 3}};

        int[][] matrix1 = new int[][]{
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}};


        int[][] matrix2 = new int[][]{
                { 1,  2,  3,  4, 0},
                { 5,  6,  7,  8, 0},
                { 9, 10, 11, 12, 0},
                {13, 14, 15, 16, 0},
                {17, 18, 19, 20, 0}};

        int[][] matrix3 = new int[0][];
        int[][] matrix4 = {{1}};
        int[][] matrix5 = new int[][] {null};

        if (arrayValidation(matrix)) {
            System.out.println("Matrix BEFORE");
            matrixPrint(matrix);
        }

        rotateClockwise(matrix);

        if (arrayValidation(matrix)) {
            System.out.println("Matrix AFTER rotation");
            matrixPrint(matrix);
        }
    }

    public static int[][] rotateClockwise(int[][] arg) {
        if (arrayValidation(arg)){
            if (arg.length > 1){
                    matrixDiagonalReflection(arg);
                    matrixHorizontalReflection(arg);
            }
            return arg;
        } else {
            return null;
        }
    }

    private static boolean arrayValidation(int [][] arg){
        boolean b = true;
        if ((arg != null) && (arg.length >= 1)) {
                if (arg == null){
                    b = false;
                } else {
                    if (arg.length > 1){
                        for (int i = 0; i < arg.length; i++) {
                            if ((arg[i] == null) || (arg[i].length != arg.length) || (arg[i].length == 0)) {
                                b = false;
                            }
                        }
                    } else {
                        if (arg[0] == null) {
                            b = false;
                        }
                    }
                }
        } else {
            b = false;
        }
        return b;
    }

    private static void matrixDiagonalReflection (int[][] arg){
        for (int i = 0; i < arg.length; i++) {
            for (int j = 0; j < (arg[0].length - i); j++) {
                int tmp = arg[i][j];
                arg[i][j] = arg[arg.length - 1 - j][arg[0].length - 1 - i];
                arg[arg.length - 1 - j][arg[0].length - 1 - i] = tmp;
            }
        }
    }

    private static void matrixHorizontalReflection (int[][] arg){
        for (int i = 0; i < (arg.length / 2); i++) {
            for (int j = 0; j < (arg[0].length); j++) {
                int tmp = arg[i][j];
                arg[i][j] = arg[arg.length - 1 - i][j];
                arg[arg.length - 1 - i][j] = tmp;
            }
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
