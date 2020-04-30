package example;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExtendedThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadExtende threadExtend = new ThreadExtende();
        threadExtend.setName("Extended Thread");
        threadExtend.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            sleepOneSecond();
        }
    }

    private static void sleepOneSecond() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
    }
}

class ThreadExtende extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                sleepOneSecond();
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadExtende.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private static void sleepOneSecond() throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
    }
}
