public class App {
    public static void main(String[] args) {
        System.err.println(f());
    }
    public static int f() {
        try {
            System.out.println("Block TRY return " + 0);
            return 0;
        } finally {
            System.out.println("Block FINALLY output " + 1);
            System.err.println(1);
        }
    }
}