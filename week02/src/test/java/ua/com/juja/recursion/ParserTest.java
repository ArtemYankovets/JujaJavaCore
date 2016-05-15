package ua.com.juja.recursion;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ParserTest {

    @Test
    public static void test_123(){
        String source = "123";
        int actual = Parser.eval(source);
        int expected = 123;
        assertEquals(expected, actual);
    }

    @Test
    public static void test_6(){
        String source = "2*3";
        int actual = Parser.eval(source);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public static void test_8(){
        String source = "(1+3)*2";
        int actual = Parser.eval(source);
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public static void test_0(){
        String source = "((13/6)*2-5)+1";
        int actual = Parser.eval(source);
        int expected = 0;
        assertEquals(expected, actual);
    }


}
