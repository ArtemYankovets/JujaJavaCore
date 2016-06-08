package ua.com.juja.multithreading.sample_1_run_thread;

import ua.com.juja.multithreading.ThreadUtils;

public class Sample2_ImplementsRunnable {

    static class MyRunnable implements Runnable {

        private String message;

        public MyRunnable(String message) {
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
        Runnable task1 = new MyRunnable("Я круче!");
        Runnable task2 = new MyRunnable("Нет Я!");

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        thread1.start();
        thread2.start();
    }
}
