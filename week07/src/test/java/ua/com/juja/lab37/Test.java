package ua.com.juja.lab37;

public class Test {
    public static void main(String[] args) {
        // Integer.MIN_VALUE = -2147483648
        String actual = StringUtils.rightShift("0123456789", Integer.MIN_VALUE);
        String expected = "8901234567";

        if (!actual.equals(expected)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}