package example.thread_daemon;

import java.util.concurrent.TimeUnit;

public class Daemon_Thread2 {
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            while(true){
                System.out.println("Daemon thread");
                try {
                    TimeUnit.SECONDS.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println("main thread");
        System.out.println("main thread stop");
    }
}
