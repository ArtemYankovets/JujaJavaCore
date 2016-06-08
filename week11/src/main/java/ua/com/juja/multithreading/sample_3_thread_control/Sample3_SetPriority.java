package ua.com.juja.multithreading.sample_3_thread_control;

import ua.com.juja.multithreading.ThreadUtils;

public class Sample3_SetPriority {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ThreadUtils.print("Я круче!");

                    ThreadUtils.someLogic(1000000);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ThreadUtils.print("Нет я!");

                    ThreadUtils.someLogic(1000000);
                }
            }
        });

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }

}
