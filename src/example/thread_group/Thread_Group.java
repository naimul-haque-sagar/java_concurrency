package example.thread_group;

public class Thread_Group {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getMaxPriority());

        ThreadGroup threadGroup=new ThreadGroup("First Thread Group");
        System.out.println(threadGroup.getName());
        System.out.println(threadGroup.getParent().getName());

        ThreadGroup threadGroup1=new ThreadGroup(threadGroup,"Second Thread Group");
        System.out.println(threadGroup1.getName());
        System.out.println(threadGroup1.getParent().getName());
    }
}
