package ua.com.juja.multithreading.sample_3_thread_control;

import ua.com.juja.multithreading.ThreadUtils;

public class Sample1_StartOrRun {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 10;
                while (--count > 0) {
                    ThreadUtils.print("Thread1");

                    ThreadUtils.sleep(10);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 10;
                while (--count > 0) {
                    ThreadUtils.print("Thread2");

                    ThreadUtils.sleep(10);
                }
            }
        });


        ThreadUtils.print("Running 1");

//        thread1.run();
        thread1.start();

        ThreadUtils.print("Running 2");

//        thread2.run();
        thread2.start();

        ThreadUtils.print("Finish");
    }

}
