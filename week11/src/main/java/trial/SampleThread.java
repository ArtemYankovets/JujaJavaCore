package trial;

public class SampleThread {
    public static void main(String[] args) throws InterruptedException {
//        new Thread(new Runnable() {
//            public void run() {
//                for (int i = 0; i < 10; i++) {
//                    System.out.println("Hello");
//                }
//            }
//        }).start();

        for (int i = 0; i < 10; i++) {
            sillyWork();
            System.out.println("Bye");
        }

    }

    private static void sillyWork() {
        double d = 2.0;
        for (int k = 0; k < 10_000_000 ; k++){
            d = Math.sin(d);
        }
    }
}
}
