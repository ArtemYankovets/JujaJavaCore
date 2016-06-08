package ua.com.juja.multithreading.sample_3_thread_control;

import ua.com.juja.multithreading.ThreadUtils;

public class Sample5_Join {

    static class MyRunnable implements Runnable {

        private int count;

        public MyRunnable(int count) {
            this.count = count;
        }

        @Override
        public void run() {
            while (--count > 0) {
                ThreadUtils.print(String.valueOf(count));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread2 = new Thread(new MyRunnable(20));
        Thread thread1 = new Thread(new MyRunnable(10));
        thread1.setDaemon(true);

        thread1.start();
        thread2.start();

        thread2.join();
        ThreadUtils.print("Thread 2 finished");

        thread1.join();
        ThreadUtils.print("Thread 1 finished");
    }

}
