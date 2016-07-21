
public class StringCompare {

    public static void main(String[] args) {
//        String input = "some test input";
//        String expected = "manually reversed string";

        char[] arr = {'e', 'v', 'o', 'l', '4'};
        String input = "evol4";
        String expected = "4l"+"ove";

        System.out.println("input " + input);
        System.out.println("expected " + expected);

        System.out.println(expected.equals(reverse(input)));

    }

    public static String reverse(String s) {
        char[] a = s.toCharArray();
        char[] b = new char[a.length];
        for (int i = 0; i < a.length; i++) {
            b[(a.length - 1) - i] = a[i];
        }
        return new String(b);
    }
}