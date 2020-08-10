package example.thread_group;

public class Thread_Group1 {
    public static void main(String[] args) {
        ThreadGroup threadGroup=new ThreadGroup("First Thread Group");
        Thread thread=new Thread(threadGroup,()-> System.out.println("Thread -0"));
        Thread thread1=new Thread(threadGroup,()-> System.out.println("Thread -1"));
        Thread thread2=new Thread(threadGroup,()-> System.out.println("Thread -2"));
        threadGroup.setMaxPriority(4);

        Thread thread3=new Thread(threadGroup,()-> System.out.println("Thread 3"));
        Thread thread4=new Thread(threadGroup,()-> System.out.println("Thread 4"));
        Thread thread5=new Thread(threadGroup,()-> System.out.println("Thread 5"));

        System.out.println(thread.getPriority());
        System.out.println(thread1.getPriority());
        System.out.println(thread2.getPriority());

        System.out.println(thread3.getPriority());
        System.out.println(thread4.getPriority());
        System.out.println(thread5.getPriority());

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        Thread[] threads=new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (Thread x:threads) System.out.println("found "+x.getName());
    }
}
