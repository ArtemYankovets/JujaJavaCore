package ua.com.juja.lab37;

import ua.com.juja.lab37.StringUtils;

public class Test2 {
    public static void main(String[] args) {
        String actual = StringUtils.rightShift("ABC", -1);
        String expected = "BCA";

        if (!actual.equals(expected)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}