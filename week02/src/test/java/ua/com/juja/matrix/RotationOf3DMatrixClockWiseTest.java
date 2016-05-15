package ua.com.juja.matrix;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Artem on 15.04.2016.
 */
public class RotationOf3DMatrixClockWiseTest {

    @Test
    public void test_null(){
        int[][][] expecteds = null;

        int[][][] soursMatrix = null;

        int[][][] actuals = RotationOf3DMatrixClockWise.rotateClockwise(soursMatrix);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test_equalsize(){
        int[][][] expecteds = null;

        int[][][] soursMatrix = new int[10][9][10];

        int[][][] actuals = RotationOf3DMatrixClockWise.rotateClockwise(soursMatrix);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test_1_1(){
        int[][][] expecteds = new int[][][]{{{1}}};

        int[][][] soursMatrix = new int[][][]{{{1}}};

        int[][][] actuals = RotationOf3DMatrixClockWise.rotateClockwise(soursMatrix);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test_2x_2x(){
        int[][][] expecteds = new int[][][]{
                {{1, 5}, {2, 6}},
                {{3, 7}, {4, 8}}};

        int[][][] soursMatrix = new int[][][]{
                {{1, 2}, {3, 4}},
                {{5, 6}, {7, 8}}};

        int[][][] actuals = RotationOf3DMatrixClockWise.rotateClockwise(soursMatrix);
        Assert.assertArrayEquals(expecteds, actuals);
    }

    @Test
    public void test_3x_3x(){
        int[][][] expecteds = new int[][][]{
                {{10, 40, 70}, {11, 41, 71}, {12, 42, 72}},
                {{20, 50, 80}, {21, 51, 81}, {22, 52, 82}},
                {{30, 60, 90}, {31, 61, 91}, {32, 62, 92}}};

        int[][][] soursMatrix = new int[][][]{
                {{10, 11, 12}, {20, 21, 22}, {30, 31, 32}},
                {{40, 41, 42}, {50, 51, 52}, {60, 61, 62}},
                {{70, 71, 72}, {80, 81, 82}, {90, 91, 92}}};

        int[][][] actuals = RotationOf3DMatrixClockWise.rotateClockwise(soursMatrix);
        Assert.assertArrayEquals(expecteds, actuals);
    }
}
