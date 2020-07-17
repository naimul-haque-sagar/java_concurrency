package example.thread_create;

import java.util.logging.Level;
import java.util.logging.Logger;

public class RunnableThreadLambda {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                doWork();
            } catch (InterruptedException ex) {
                Logger.getLogger(RunnableThreadLambda.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        t.setName("ONe");
        t.start();

        Thread t2 = new Thread(() -> {
            try {
                doWork();
            } catch (InterruptedException ex) {
                Logger.getLogger(RunnableThreadLambda.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        t2.setName("Two");
        t2.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }

    private static void doWork() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}
