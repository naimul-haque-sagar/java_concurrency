package example.thread_join;

public class Join_Method1 {
    public static void main(String[] args) {
        Thread thread1=new Thread(()-> { for (int i=0;i<5;i++) System.out.println("thread1"); });
        Thread thread3=new Thread(()-> {for (int i=0;i<5;i++) System.out.println("thread3");});
        Thread thread2=new Thread(()-> {
            for (int i=0;i<5;i++) {
                try {
                    thread1.join();
                    thread3.join();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
                System.out.println("thread2");
            }
        });

        thread2.start();
        thread1.start();
        thread3.start();
    }
}
