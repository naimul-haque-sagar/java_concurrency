package example.thread_daemon;

//daemon thread ends automatically when all non-daemon thread finished

public class Daemon_Thread1 {
    public static void main(String[] args) {
        Thread daemonThread=new Thread(()->{
            for (int i=0;i<5;i++){
                System.out.println("Daemon Thread");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
            }
        });
        Thread thread2=new Thread(()->{
            for (int i=0;i<5;i++){
                System.out.println("Thread two ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
            }
        });
        Thread thread3=new Thread(()->{
            for (int i=0;i<5;i++){
                System.out.println("Thread three ");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();
        thread2.start();
        thread3.start();
    }
}
