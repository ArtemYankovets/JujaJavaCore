package ua.com.juja.multithreading.sample_4_synchronized;

import ua.com.juja.multithreading.ThreadUtils;

public class Sample2_DeadLock {

    public static void main(String[] args) throws InterruptedException {
        final Object object1 = new Object();
        final Object object2 = new Object();

        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object1) {
                    ThreadUtils.sleep(100);

                    synchronized (object2) {
                        ThreadUtils.print("Done1!");
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object2) {
                    ThreadUtils.sleep(100);

                    synchronized (object1) {
                        ThreadUtils.print("Done2!");
                    }
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

}
