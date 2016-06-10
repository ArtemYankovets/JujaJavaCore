package ua.com.juja.samples;

public class Sample_Thread_Join {
    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new MyRunnable("Say Hello");
        Thread th = new Thread(r1);

        th.start();

        th.join();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(500);
            System.out.println("Bye");
        }
        System.out.println("That's All!!!");
    }

    static class MyRunnable implements Runnable{

        String name;

        public MyRunnable(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hello");
                double d = 2.0;
                for (int k = 0; k < 10_000_000; k++) {
                    d = Math.sin(d);
                }
            }
        }
    }
}
