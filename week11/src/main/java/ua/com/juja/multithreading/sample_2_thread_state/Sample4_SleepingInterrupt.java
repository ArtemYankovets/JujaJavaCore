package ua.com.juja.multithreading.sample_2_thread_state;

import ua.com.juja.multithreading.ThreadUtils;

import java.util.Calendar;

public class Sample4_SleepingInterrupt {

    public static void main(String[] args) {
        final Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ThreadUtils.print("Sleeping");
                    long time = now();
                    try {

                        Thread.sleep(10000);

                    } catch (InterruptedException e) {
                        ThreadUtils.print("Sleep interrupted: " + (now() - time) + "ms");
                    }
                    ThreadUtils.print("Running");
                }
            }
        });

        Thread interrupter = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ThreadUtils.print("Try to interrupt..");

                    thread.interrupt();

                    ThreadUtils.sleep(1000);
                }
            }
        });

        thread.start();
        interrupter.start();
    }

    private static long now() {
        return Calendar.getInstance().getTimeInMillis();
    }

}
