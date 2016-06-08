package ua.com.juja.multithreading.sample_1_run_thread;

import ua.com.juja.multithreading.ThreadUtils;

public class Sample0_MainMethod {

    public static void main(String[] args) throws InterruptedException {
        ThreadUtils.print("Начали!");

        Thread.currentThread().join();

        ThreadUtils.print("закончили!");
    }

}
