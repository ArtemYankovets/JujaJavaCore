import java.io.*;

public class StringCompare {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String input = "qwerty\uD83F\uDFFA";
        String expected = "\uD83F\uDFFAytrewq";

        System.out.println("input \t\t" + input);
        System.out.println("expected \t" + expected);

        String result = reverse(input);
        System.out.println("reverse result \t\t\t\t" + result);

        String result2 = reverseByArray(input);
        System.out.println("reverseByArray result \t\t" + result2);

        System.out.println();
        System.out.println(expected.equals(result));
        System.out.println(expected.equals(result2));

    }

    public static String reverse(String s) {
        char[] a = s.toCharArray();
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[(a.length - 1) - i] = a[i];
        }
        return new String(b);
    }

    public static String reverseByArray(String s) throws UnsupportedEncodingException {
        byte [] a = new byte[0];
        a = s.getBytes("UTF-32");
        byte[] b = new byte[a.length];
        int sizeChar = a.length / 4;
        for (int i = 0; i < sizeChar; i++) {
            System.arraycopy(a, i*4, b, (sizeChar - 1 - i)*4, 4);
        }
        return new String(b, "UTF-32");
    }
}