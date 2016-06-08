package ua.com.juja.multithreading.sample_3_thread_control;

import ua.com.juja.multithreading.ThreadUtils;

public class Sample4_GetCurrentThread {

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            Thread thread = Thread.currentThread();
            ThreadUtils.print(thread.getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyRunnable());
        Thread thread2 = new Thread(new MyRunnable());

        Thread main = Thread.currentThread();
        ThreadUtils.print(main.getName());
        thread1.start();
        thread2.start();
    }

}
