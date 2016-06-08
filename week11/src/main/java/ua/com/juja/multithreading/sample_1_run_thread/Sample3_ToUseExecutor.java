package ua.com.juja.multithreading.sample_1_run_thread;

import ua.com.juja.multithreading.ThreadUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Sample3_ToUseExecutor {

    static class IAmTheBest implements Runnable {

        private String message;

        public IAmTheBest(String message) {
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
        Runnable task1 = new IAmTheBest("Я круче!");
        Runnable task2 = new IAmTheBest("Нет Я!");
        Runnable task3 = new IAmTheBest("А вот и фиг!");

//        Executor executor = Executors.newCachedThreadPool();  // столько сколько надо с последующим reuse
//        Executor executor = Executors.newSingleThreadExecutor(); // только один Thread для всех тасков
        Executor executor = Executors.newFixedThreadPool(2); // заданное число Thread, все что не помещается в очередь
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3);

        ThreadUtils.print("Пока!!");
    }

}
