package ua.com.juja.multithreading.sample_2_thread_state;

import ua.com.juja.multithreading.ThreadUtils;

import java.io.*;

public class Sample8_Blocked {

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            while (true) {
                ThreadUtils.print("Blocked");

                try (OutputStream os = new FileOutputStream(new File("1.txt"))) {
                    os.write(new byte[1000000000]);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                ThreadUtils.print("Running");
            }
        }
    }

    public static void main(String[] args) {

        final Thread main = new Thread(new MyRunnable());

        Thread interrupter = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ThreadUtils.print("Try to interrupt...");

                    main.interrupt();

                    ThreadUtils.sleep(100);
                }
            }
        });

        main.start();
        interrupter.start();
    }

}
