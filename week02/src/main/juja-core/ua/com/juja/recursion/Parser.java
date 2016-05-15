package ua.com.juja.recursion;

public class Parser {
    public static void main(String[] args) {
        System.out.println(eval("123"));
        System.out.println(eval("2*3"));
        System.out.println(eval("2*(1+3)"));
        System.out.println(eval("1+(5-2*(13/6))"));
    }

    public static int eval(String expr) {
        return eval(expr, expr.length() - 1, 0);
    }

    private static int eval(String expr, int from, int to) {

        if (expr.charAt(from) == ')') {
            return eval(expr, from - 1, to + 1);
        } else {
            int pos = from;
            while (pos >= to) {

                if (Character.isDigit(expr.charAt(pos))) {
                    pos--;
                } else {
                    int rightOperand = Integer.valueOf(expr.substring(pos + 1, from + 1));

                    char operation = expr.charAt(pos);

                    int leftOperand = eval(expr, pos-1, to);

                    switch (operation) {
                        case '+':
                            return leftOperand + rightOperand;
                        case '-':
                            return leftOperand - rightOperand;
                        case '*':
                            return leftOperand * rightOperand;
                        case '/':
                            return leftOperand / rightOperand;
                    }
                }
            }
            return Integer.valueOf(expr.substring(to, from+1));
        }
    }
}
