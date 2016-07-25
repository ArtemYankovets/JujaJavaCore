import java.io.*;
import java.util.Arrays;

public class StringRevers {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String input = "qwerty\uD83F\uDFFA";
        String expected = "\uD83F\uDFFAytrewq";

        System.out.println("input string \t\t" + input);
        System.out.println("expected string \t" + expected);

        System.out.println();

        System.out.println("Method revers results:");
        String result = reverse(input);
        System.out.println("\tresult is \t\t" + result);
        System.out.println("\t" + expected.equals(result));

        System.out.println("Method reversByArray results:");
        String result2 = reverseByArray(input);
        System.out.println("\tresult is \t\t" + result2);
        System.out.println("\t" + expected.equals(result2));

        System.out.println("Method reversCodePoints results:");
        String result3 = reverseCodePoints(input);
        System.out.println("\tresult is \t\t" + result3);
        System.out.println("\t" + expected.equals(result3));
        System.out.println("input string\t " + Arrays.toString(input.getBytes("UTF-32")));
        System.out.println("expected string\t " + Arrays.toString(expected.getBytes("UTF-32")));
        System.out.println("result string\t " + Arrays.toString(result3.getBytes("UTF-32")));
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
        byte[] a = new byte[0];
        a = s.getBytes("UTF-32");
        byte[] b = new byte[a.length];
        int sizeChar = a.length / 4;
        for (int i = 0; i < sizeChar; i++) {
            System.arraycopy(a, i * 4, b, (sizeChar - 1 - i) * 4, 4);
        }
        return new String(b, "UTF-32");
    }

    public static String reverseCodePoints(String str) {
        String result = "";
        int size = str.codePointCount(0, str.length());
//        System.out.println("The expression " + str + " consist of " + size + " symbols");
        for (int i = size - 1; i >= 0; i--) {
            int codePoint = str.codePointAt(str.offsetByCodePoints(0, i));
//            System.out.println("Symbol on position "+ (i + 1) + " equal " + (char) codePoint + " and codePoint = " + codePoint);
            result += (char) codePoint;
        }
        return result;
    }
}