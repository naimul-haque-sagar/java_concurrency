package example;

class Mythread {
    public void called(String name) throws InterruptedException {
        synchronized(this){
            for (int i=0;i<5;i++){
                System.out.println("Thread called "+name);
                Thread.sleep(1000);
            }
        }
    }
}

class ThreadCaller extends Thread{
    Mythread mythread;
    String name;

    ThreadCaller(Mythread mythread,String name){
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

public class Synchronized_Block {
    public static void main(String[] args) {
        Mythread mythread=new Mythread();
        Mythread mythread1=new Mythread();
        ThreadCaller threadCaller=new ThreadCaller(mythread,"call him");
        ThreadCaller threadCaller1=new ThreadCaller(mythread,"call him now");
        threadCaller.start();
        threadCaller1.start();
    }
}

