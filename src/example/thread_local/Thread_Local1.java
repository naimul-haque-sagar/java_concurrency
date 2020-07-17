package example.thread_local;

public class Thread_Local1 {
    ThreadLocal<Integer> number=new ThreadLocal<>();

    public Integer getNumber(){
        return number.get();
    }

    public void setNumber(Integer number){
        this.number.set(number);
    }

    public static void main(String[] args) throws InterruptedException {
       Thread_Local1 thread_local1=new Thread_Local1();

       setRandomNumber(thread_local1);

       Thread thread=new Thread(()->{
           try {
               setRandomNumber(thread_local1);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       });


        Thread thread1=new Thread(()->{
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                setRandomNumber(thread_local1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Thread thread2=new Thread(()->{
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                setRandomNumber(thread_local1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        thread1.start();
        thread2.start();

        thread2.join();
    }

    public static void setRandomNumber(Thread_Local1 thread_local1) throws InterruptedException {
        thread_local1.setNumber((int) (Math.random()*50));
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName());
        System.out.println(thread_local1.getNumber());
    }
}
