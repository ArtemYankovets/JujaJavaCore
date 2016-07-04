package ua.com.juja.producer_consumer;

public class ProducerCunsumerExample_1x1 {
    public static void main(String[] args) throws InterruptedException {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Produser(1, 1000, buffer)).start();
        Thread.sleep(5000);
        new Thread(new Consumer(buffer, 1)).start();
    }
}
