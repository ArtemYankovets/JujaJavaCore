package ua.com.juja.lab37;

public class StringUtils {
    public static void main(String[] args) {
        String s = "012345";
        s = s.replaceAll("0", "A");

        String b = "ABCDE";
        System.out.println("ORIGIN \t" + b);
        System.out.println("REZULT \t" + rightShift(b, -2147483648));
    }

    public static String rightShift(String arg, int delta) {
        if (arg.equals("")) {
            return arg;
        } else {
            if (Math.abs(delta % arg.length()) >= 1) {
                int tmp = Math.abs(delta / arg.length());
                delta = (delta > 0) ? (delta - (tmp * arg.length())) : delta + (tmp * arg.length());
            }

            if ((delta == 0) || (arg.length() <= 1)) {
                return arg;
            } else {
                String newArg = (delta > 0) ? arg.substring(arg.length() - delta, arg.length()) + arg.substring(0, arg.length() - delta) : arg.substring(Math.abs(delta), arg.length()) + arg.substring(0, Math.abs(delta));
                return newArg;
            }
        }
    }
}
