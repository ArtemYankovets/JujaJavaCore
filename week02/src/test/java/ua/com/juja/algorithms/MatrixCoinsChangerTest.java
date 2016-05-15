package ua.com.juja.algorithms;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Artem on 10.04.2016.
 */
public class MatrixCoinsChangerTest {

    @Test
    public void test(){
        assertEquals(4, MatrixCoinsChanger2.getCombinations(5));
        assertEquals(11, MatrixCoinsChanger2.getCombinations(10));
        assertEquals(3_953, MatrixCoinsChanger2.getCombinations(100));
        assertEquals(233_639, MatrixCoinsChanger2.getCombinations(278));
        assertEquals(589_078_306, MatrixCoinsChanger2.getCombinations(1500));
        assertEquals(514_766, MatrixCoinsChanger2.getCombinations(333));
        assertEquals(590_9759_71, MatrixCoinsChanger2.getCombinations(1501));
    }
}
