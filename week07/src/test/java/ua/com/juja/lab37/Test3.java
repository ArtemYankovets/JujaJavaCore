package ua.com.juja.lab37;

public class Test3 {
    public static void main(String[] args) {
        String actual = StringUtils.rightShift("", -1000000);
        String expected = "";

        if (!actual.equals(expected)) {
            throw new AssertionError();
        }

        System.out.print("OK");
    }
}