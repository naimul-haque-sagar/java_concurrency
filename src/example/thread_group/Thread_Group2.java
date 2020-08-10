package example.thread_group;

import java.util.concurrent.TimeUnit;

public class Thread_Group2 {
    public static void main(String[] args) {
        ThreadGroup threadGroup=new ThreadGroup("First thread group");
        ThreadGroup threadGroup2=new ThreadGroup(threadGroup,"Second thread group");

        Thread thread=new Thread(threadGroup,()-> System.out.println("Thread -0"));
        Thread thread1=new Thread(threadGroup,()-> System.out.println("Thread -1"));
        Thread thread2=new Thread(threadGroup,()-> System.out.println("Thread -2"));

        thread.start();
        thread1.start();
        thread2.start();

        System.out.println(threadGroup.activeCount());
        System.out.println(threadGroup.activeGroupCount());
        threadGroup.list();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }

        System.out.println(threadGroup.activeCount());
        System.out.println(threadGroup.activeGroupCount());
        threadGroup.list();

    }
}
