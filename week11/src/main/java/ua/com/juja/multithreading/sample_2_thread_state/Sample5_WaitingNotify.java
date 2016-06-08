package ua.com.juja.multithreading.sample_2_thread_state;

import ua.com.juja.multithreading.ThreadUtils;

/**
 * В части случаев один поток зависает в ожидании уже готовых данных
 * Исправить ошибку добавлением if (!ready)
 * Сообщить о Spurious wakeups
 * Показать, что иногда if недостаточно разремарив releaser.start();
 * Взять в while (!ready)
 */
public class Sample5_WaitingNotify {
    static Object monitor = new Object();
//    static boolean ready = false;

    public static void main(String[] args) {

        final Thread main = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    try {
//                        if (!ready) {
                            ThreadUtils.print("Waiting...");
                            monitor.wait();
                            ThreadUtils.print("Wakeup");
//                        }
//                        if (!ready) {
//                            print("ERROR!!! Data not ready");
//                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                ThreadUtils.print("----------Running----------");
                ThreadUtils.sleep(500);
            }
        });

        Thread notifier = new Thread(new Runnable() {
            @Override
            public void run() {
//                if (!ready) {
                    synchronized (monitor) {
                        ThreadUtils.print("Ready = true. Try to notify...");
//                        ready = true;
                        monitor.notify();
                        ThreadUtils.print("After notify");
                    }
//                }

                ThreadUtils.sleep(1000);
            }
        });

//        Thread releaser = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    synchronized (monitor) {
//                        ready = false;
//                        printUniq("Ready = false");
//                    }
//
//                    sleep(1);
//                }
//            }
//        });
//        releaser.setDaemon(true);

        main.start();
        notifier.start();
//        releaser.start();
    }

}
