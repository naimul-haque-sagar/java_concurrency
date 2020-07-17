package example.thread_local;

class SharedNumber{
    ThreadLocal<Integer> number=new ThreadLocal<>();

    public Integer getNumber(){
        return number.get();
    }

    public void setNumber(Integer number){
        this.number.set(number);
    }
}

public class Thread_Local {
    public static void main(String[] args) throws InterruptedException {
        SharedNumber sharedNumber=new SharedNumber();
        SharedValueSetter sharedValueSetter=new SharedValueSetter(sharedNumber);
        sharedValueSetter.setValue();

        Thread thread=new Thread(()->{
            SharedValueSetter sharedValueSetter1=new SharedValueSetter(sharedNumber);
            try {
                sharedValueSetter1.setValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread1=new Thread(()->{
            try {
                thread.join();
                SharedValueSetter sharedValueSetter2=new SharedValueSetter(sharedNumber);
                sharedValueSetter2.setValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2=new Thread(()->{
            try {
                thread1.join();
                SharedValueSetter sharedValueSetter3=new SharedValueSetter(sharedNumber);
                sharedValueSetter3.setValue();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        thread.setName("Thread ");
        thread1.setName("Thread one");
        thread2.setName("Thread two");

        thread.start();
        thread1.start();
        thread2.start();
    }
}

class SharedValueSetter{
    SharedNumber sharedNumber;

    SharedValueSetter(SharedNumber sharedNumber){
        this.sharedNumber=sharedNumber;
    }

    void setValue() throws InterruptedException {
        sharedNumber.setNumber((int) (Math.random()*100));
        System.out.println(sharedNumber.getNumber());
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}