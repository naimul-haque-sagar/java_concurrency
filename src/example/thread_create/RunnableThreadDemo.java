package example.thread_create;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableThreadDemo {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable myRunnable = new MyRunnable();
        Thread t = new Thread(myRunnable);
        t.setName("runnable thread");
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            sleepOneSecond();
        }

    }

    private static void sleepOneSecond() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                sleepOneSecond();
            } catch (InterruptedException ex) {
                Logger.getLogger(MyRunnable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void sleepOneSecond() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
    }

}
