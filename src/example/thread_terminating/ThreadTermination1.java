package example.thread_terminating;

public class ThreadTermination1 {
    public static void main(String[] args) throws InterruptedException {
        thread.start();
        Thread.sleep(4000);
        thread1.start();
        Thread.sleep(3000);
        endThread();
        Thread.sleep(500);
        thread2.start();
    }

    static boolean run=false;
    static Thread thread=new Thread(()->{
        Thread.currentThread().setName("1st Thread");
        while (!run) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();Thread.currentThread().interrupt();
                throw new AssertionError(e);
            }
        }
    });

    static Thread thread1=new Thread(()->{
        Thread.currentThread().setName("2nd Thread");
        for (int i=0;i<4;i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new AssertionError(e);
            }
        }
    });

    static Thread thread2=new Thread(()->{
        Thread.currentThread().setName("3rd Thread");
        for (int i=0;i<4;i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new AssertionError(e);
            }
        }
    });

    static void endThread(){
        run=true;
    }
}
