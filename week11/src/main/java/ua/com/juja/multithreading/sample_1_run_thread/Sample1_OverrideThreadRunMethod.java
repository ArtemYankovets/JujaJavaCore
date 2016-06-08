package ua.com.juja.multithreading.sample_1_run_thread;

import ua.com.juja.multithreading.ThreadUtils;

public class Sample1_OverrideThreadRunMethod {

    static class MyThread extends Thread {

        private String message;

        public MyThread(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            while (true) {
                ThreadUtils.print(message);

                ThreadUtils.sleepRandom(2000);
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new MyThread("Я круче!");
        Thread thread2 = new MyThread("Нет Я!");

        thread1.start();
        thread2.start();
    }
}
