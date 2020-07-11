package example;

public class Thread_Priority1 {
    public static void main(String[] args) {
        for (int i=0;i<5;i++) System.out.println("Main thread");

        Thread threadOne=new Thread(()->{for (int i=0;i<5;i++) System.out.println("ThreadOne");});
        Thread threadTwo=new Thread(()->{for (int i=0;i<5;i++) System.out.println("ThreadTwo");});

        threadOne.setPriority(7);
        threadTwo.setPriority(Thread.MAX_PRIORITY);
        threadOne.start();
        threadTwo.start();
    }
}
