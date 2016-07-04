package ua.com.juja.producer_consumer;

public class ProducerCunsumerExample_3x2 {
    public static void main(String[] args) throws InterruptedException {
        SingleElementBuffer buffer = new SingleElementBuffer();
        new Thread(new Produser(1, 300, buffer)).start();
        new Thread(new Produser(100, 500, buffer)).start();
        new Thread(new Produser(1000, 700, buffer)).start();
//        Thread.sleep(5000);
        new Thread(new Consumer(buffer, 1)).start();
        new Thread(new Consumer(buffer, 2)).start();
    }
}
