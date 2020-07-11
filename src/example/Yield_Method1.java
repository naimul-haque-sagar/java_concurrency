package example;

public class Yield_Method1 {
    public static void main(String[] args) {
        Thread thread=new Thread(()-> {
            for(int i=0;i<45;i++) System.out.println("Thread one"); Thread.yield();
        });
        thread.start();

        for (int i=0;i<15;i++) System.out.println("Main thread");
    }
}
