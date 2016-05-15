package ua.com.juja.matrix;

import org.junit.Test;

import java.util.Arrays;

public class MatrixRotationClockWiseTest {

    @Test
    public void test(){

        Object res = MatrixRotationClockWise.rotateClockwise(null);
        if (res != null) {
            throw new AssertionError();
        }

        Object res1 = MatrixRotationClockWise.rotateClockwise(new int[][] {{1}});
        if (!Arrays.deepEquals((Object[]) res1, new int[][]{{1}})) {
            throw new AssertionError();
        }

        Object res2 = MatrixRotationClockWise.rotateClockwise(new int[][] {null});
        if (res2 != null) {
            throw new AssertionError();
        }

        Object res3 = MatrixRotationClockWise.rotateClockwise(new int[0][]);
        if (res3 != null) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}
