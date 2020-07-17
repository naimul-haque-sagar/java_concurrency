package example.thread_join;

public class Join_Method3 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(()-> {for (int i=0;i<5;i++) System.out.println("thread1");});
        Thread thread2=new Thread(()-> {for (int i=0;i<5;i++) System.out.println("thread2");});
        Thread thread3=new Thread(()-> {for (int i=0;i<5;i++) System.out.println("thread3");});

        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread3.join();
        for (int i=0;i<5;i++) System.out.println("main");
    }
}
