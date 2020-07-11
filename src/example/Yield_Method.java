package example;

public class Yield_Method {
    public static void main(String[] args) {
        Thread thread1=new Thread(()->{
            for (int i=0;i<30;i++) {
                Thread.yield();
                System.out.println("Thread one");
            }
        });

        Thread thread2=new Thread(()->{
            for (int i=0;i<5;i++) System.out.println("Thread two");
        });

        Thread thread3=new Thread(()-> {
            for (int i = 0; i < 5; i++) System.out.println("Thread three");
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
