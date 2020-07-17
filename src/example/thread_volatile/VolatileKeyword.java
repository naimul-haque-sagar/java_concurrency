package example.thread_volatile;

import java.util.logging.Level;
import java.util.logging.Logger;

public class VolatileKeyword {

    static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag) {
                System.out.println("Into " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(VolatileKeyword.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Thread stopped");
        }).start();

        Thread.sleep(2000);
        flag = false;
        System.out.println("finished");
    }
}
