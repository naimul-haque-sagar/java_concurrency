package example.thread_interrupt;

public class Interrupt1 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            for (int i=0;i<5;i++) {
                System.out.println("thread");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
        Thread.sleep(5000);
        //interrupt only executes when target method is in sleep or wait state
        //it wake thread from sleep
        //if target thread is not in sleep or wait state interrupt acts as a flag value
        thread.interrupt();
    }
}
