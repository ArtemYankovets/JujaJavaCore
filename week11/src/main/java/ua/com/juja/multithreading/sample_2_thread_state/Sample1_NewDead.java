package ua.com.juja.multithreading.sample_2_thread_state;

import ua.com.juja.multithreading.ThreadUtils;

public class Sample1_NewDead {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 10;
                while (--count > 0) {
                    ThreadUtils.print("Running<->Runnable");

                    ThreadUtils.someLogic(1000000);
                }
                ThreadUtils.print("Almost Dead");
            }
        });

        ThreadUtils.print("New");

        thread.start();

        ThreadUtils.print("Runnable");

        thread.join();

        ThreadUtils.print("Dead");
    }

}
