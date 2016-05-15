package ua.com.juja.matrix;

/**
 * Created by Artem on 12.04.2016.
 */
public class RotationOf3DMatrixClockWise {
    public static void main(String[] args) {

        int[][][] matrix4 = {{{1}}};

        int[][][] matrix2 = new int[][][]{
                {{1, 2}, {3, 4}},
                {{5, 6}, {7, 8}}};

        int[][][] matrix = new int[][][]{
                {{10, 11, 12}, {20, 21, 22}, {30, 31, 32}},
                {{40, 41, 42}, {50, 51, 52}, {60, 61, 62}},
                {{70, 71, 72}, {80, 81, 82}, {90, 91, 92}}};

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

    public static int[][][] rotateClockwise(int[][][] arg) {
        if (arrayValidation(arg)){
            if (arg.length > 1 || arg[0].length > 1 || arg[0][0].length > 1){
                    matrixDiagonalReflection(arg);
                    matrixHorizontalReflection(arg);
            }
            return arg;
        } else {
            return null;
        }
    }

    private static boolean arrayValidation(int [][][] arg){
        boolean b = true;
        if (((arg != null) && (arg.length >= 1)) && ((arg[0] != null) && (arg[0].length >= 1)) && ((arg[0][0] != null) && (arg[0][0].length >= 1))) {
                if ((arg == null) || (arg[0] == null) || (arg[0][0] == null)){
                    b = false;
                } else {
                    if ((arg.length > 1) && (arg[0].length > 1) && (arg[0][0].length > 1)){
                        for (int i = 0; i < arg.length; i++) {
                            for (int j = 0; j < arg[0].length; j++) {
                                if ((arg[i] == null) || (arg[i].length != arg.length) || (arg[i].length == 0)) {
                                    b = false;
                                }
                                if ((arg[i][j] == null) || (arg[i][j].length != arg.length) || (arg[i][j].length == 0)) {
                                    b = false;
                                }
                            }
                        }
                    } else {
                        if ((arg[0] == null) || (arg[0][0] == null)) {
                            b = false;
                        }
                    }
                }
        } else {
            b = false;
        }
        return b;
    }

    private static void matrixDiagonalReflection (int[][][] arg){
        int size = arg.length;


        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = j; k < size; k++) {
                    int tmp = arg[i][j][k];
                    arg[i][j][k] = arg[i][k][j];
                    arg[i][k][j] = tmp;
                }
            }
        }
    }

    private static void matrixHorizontalReflection (int[][][] arg){
        for (int j = 0; j < arg.length; j++) {
            for (int i = 0; i < arg[j].length; i++) {
                for (int k = i; k < arg[j][i].length; k++) {
                    int tmp = arg[i][j][k];
                    arg[i][j][k] = arg[k][j][i];
                    arg[k][j][i] = tmp;
                }
            }
        }
    }

    public static void matrixPrint(int[][][] matrix){
        int size = matrix.length;
        for (int i = 0; i < size ; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    System.out.print(matrix[i][j][k] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println();
    }
}
