package example;

public class Thread_Priority {
    public static void main(String[] args) {
        //by default thread priority is 5
        //thread priority is extends from parent thread
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(thread.getPriority());
        System.out.println(thread1.getPriority());

        Thread.currentThread().setPriority(7);
        Thread thread2=new Thread(()-> System.out.println("Hello from thread2"));
        System.out.println(Thread.currentThread().getPriority());
        //thread2 is declared in between main thread
        //that's why thread2's priority will be extends from parent thread
        //priority will be 7 as it's parent's priority is 7
        System.out.println(thread2.getPriority());
    }
    static Thread thread=new Thread(()-> System.out.println("Hello from thread"));
    static Thread thread1=new Thread(()-> System.out.println("Hello from thread1"));
}

