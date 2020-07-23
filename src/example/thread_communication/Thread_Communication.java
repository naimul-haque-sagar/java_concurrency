package example.thread_communication;

public class Thread_Communication {
    public static void main(String[] args) throws InterruptedException {
        Thread_One thread_one=new Thread_One();
        thread_one.start();
        synchronized (thread_one){
            thread_one.wait();
        }
        Thread.sleep(3000);
        System.out.println("Main thread finished");
    }
}

class Thread_One extends Thread{
    @Override
    public void run() {
        Thread_Two thread_two=new Thread_Two();
        thread_two.start();
        synchronized (thread_two){
            try {
                thread_two.wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new AssertionError(e);
            }
            System.out.println("Thread one work finished" +
                    " going to main thread");
        }
        synchronized (this){
            this.notify();
        }
    }
}

class Thread_Two extends Thread{
    @Override
    public void run() {
        synchronized (this){
            try {
                Thread.sleep(5000);
                System.out.println("Thread Two work finished" +
                        " going to thread one");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new AssertionError(e);
            }
            this.notify();
        }
    }
}
