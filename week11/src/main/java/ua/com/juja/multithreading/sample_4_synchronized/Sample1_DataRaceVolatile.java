package ua.com.juja.multithreading.sample_4_synchronized;

import ua.com.juja.multithreading.ThreadUtils;

public class Sample1_DataRaceVolatile {

    private static volatile int number = 0; // shared state

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    number++;
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (number % 2 == 0) {
                        ThreadUtils.print(String.valueOf(number));
                    }

                    ThreadUtils.sleep(1000);
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}
