package example.thread_data_synchronization;


class Mythread1 {
    public void called(String name) throws InterruptedException {
        synchronized(Mythread1.class){
            for (int i=0;i<5;i++){
                System.out.println("Thread called "+name);
                Thread.sleep(1000);
            }
        }
    }
}

class ThreadCaller1 extends Thread{
    Mythread1 mythread;
    String name;

    ThreadCaller1(Mythread1 mythread,String name){
        this.mythread=mythread;
        this.name=name;
    }

    @Override
    public void run() {
        try {
            mythread.called(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Synchronized_Block1 {
    public static void main(String[] args) {
        Mythread1 mythread1=new Mythread1();
        Mythread1 mythread2=new Mythread1();
        ThreadCaller1 threadCaller=new ThreadCaller1(mythread1,"call him");
        ThreadCaller1 threadCaller1=new ThreadCaller1(mythread2,"call him now");
        threadCaller.start();
        threadCaller1.start();
    }
}

