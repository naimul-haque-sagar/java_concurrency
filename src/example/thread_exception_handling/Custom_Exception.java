package example.thread_exception_handling;

public class Custom_Exception implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t.getName());
        System.out.println(e.getMessage());
    }
}

class Custom_Thread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println("HI ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        throw new RuntimeException("Self made exception");
    }
}

class Run_Thread{
    public static void main(String[] args) {
        Custom_Thread custom_thread=new Custom_Thread();
        custom_thread.setName("Custom Exception Test Thread ");
        custom_thread.setUncaughtExceptionHandler(new Custom_Exception());
        custom_thread.start();
    }
}
