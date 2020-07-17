package example.thread_terminating;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadTerminator {

    private static boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (running) {
                doWork();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadTerminator.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t.start();
        Thread.sleep(5000);
        shutdown();
    }

    private static void doWork() {
        System.out.println("Hello");
    }

    private static void shutdown() {
        ThreadTerminator.running = false;
    }
}
