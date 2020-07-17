package example.thread_communication;

public class Thread_Communication1 {
    public static void main(String[] args) throws InterruptedException {
        Contact_Thread contact_thread=new Contact_Thread();
        contact_thread.start();
        synchronized (contact_thread){
            contact_thread.wait();
            System.out.println(contact_thread.total);
        }
    }
}
class Contact_Thread extends Thread{
    int total=0;
    @Override
    public void run() {
        synchronized (this){
            for (int i=0;i<100;i++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                total+=i;
            }
            this.notify();
        }
    }
}