package ua.com.juja.multithreading.sample_2_thread_state;

import ua.com.juja.multithreading.ThreadUtils;

import java.util.Calendar;

public class Sample3_SleepingEndTimer {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        ThreadUtils.print("Before sleep");
                        long time = now();

                        Thread.sleep(1000);

                        ThreadUtils.print("After sleep: " + (now() - time) + "ms");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        thread.interrupt();
    }

    private static long now() {
        return Calendar.getInstance().getTimeInMillis();
    }

}
