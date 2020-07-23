package example.thread_daemon;

public class Daemon_Thread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
           for (int i=0;i<5;i++) {
               System.out.println("Daemon thread");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   throw new AssertionError(e);
               }
           }
        });

        thread.setDaemon(true);
        thread.start();
        thread.join();
        System.out.println("Main thread");
    }
}
