package example.thread_join;

public class Join_Method2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
           for (int i=0;i<10;i++) {
               System.out.println("thread");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   throw new AssertionError(e);
               }
           }
        });

        thread.start();
       // thread.join();
        thread.join(5000);

        for (int i=0;i<5;i++) System.out.println("main");
    }
}
