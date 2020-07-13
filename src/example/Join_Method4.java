package example;

public class Join_Method4 {
    public static void main(String[] args) {
        MyThread1 myThread1=new MyThread1();
        myThread1.thread=Thread.currentThread();
        myThread1.start();
        for (int i=0;i<5;i++) System.out.println("Main thread");
    }
}
class MyThread1 extends Thread{
    Thread thread;
    @Override
    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0;i<5;i++) System.out.println("mythread1");
    }
}
