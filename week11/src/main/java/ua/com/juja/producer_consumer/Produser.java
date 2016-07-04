package ua.com.juja.producer_consumer;

import static java.lang.System.currentTimeMillis;

public class Produser implements Runnable {
    private int startValue;
    private final int period;
    private final SingleElementBuffer buffer;

    public Produser(int startValue, int period, SingleElementBuffer buffer) {
        this.buffer = buffer;
        this.period = period;
        this.startValue = startValue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(currentTimeMillis() + ": " + startValue + " produced");
                buffer.put(startValue++);
                Thread.sleep(period);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " stopped.");
                break;
            }
        }
    }
}
