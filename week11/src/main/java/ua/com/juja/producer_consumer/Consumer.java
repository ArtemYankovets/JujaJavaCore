package ua.com.juja.producer_consumer;

import static java.lang.System.currentTimeMillis;

public class Consumer implements Runnable{
    private final int id;
    private final SingleElementBuffer buffer;

    public Consumer(SingleElementBuffer buffer, int id) {
        this.id = id;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true){
            try {
                Integer elem = buffer.get();
                System.out.println(currentTimeMillis() + ": " + elem + " consumed by " + id);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopped.");
                return;
            }
        }
    }
}
