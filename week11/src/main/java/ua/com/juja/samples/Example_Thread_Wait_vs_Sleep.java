package ua.com.juja.samples;

public class Example_Thread_Wait_vs_Sleep {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                hello(1);
            }
        });

        Thread thread2 = new Thread(new Runnable(){
            @Override
            public void run() {
                hello(2);
            }
        });

        thread1.start();
        thread2.start();


    }

    private synchronized static void hello(int id) {
        System.out.println(id + " - I'm here");
        try {
            System.out.println(id + " * - wait - sleep: " + System.currentTimeMillis());
            Example_Thread_Wait_vs_Sleep.class.wait(3000);
            System.out.println(id + " wait - * - sleep: " + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println(id + " wait - sleep - *: " + System.currentTimeMillis());
        } catch (InterruptedException ignore) {/*NOP*/}
    }
}
