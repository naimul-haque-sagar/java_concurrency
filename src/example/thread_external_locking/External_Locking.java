package example.thread_external_locking;

import java.util.Vector;

class Helper{
    public static <E> E getLast(Vector<E> list){
        synchronized (list){
            int last=list.size()-1;
            return list.get(last);
        }
    }

    public static  <E> void removeLast(Vector<E> list){
        synchronized (list){
            int last=list.size()-1;
            list.remove(last);
        }
    }
}

public class External_Locking {
    public static void main(String[] args) throws InterruptedException {
        Vector<Integer> vector=new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(3);
        vector.add(4);
        vector.add(5);
        vector.add(6);

        Thread thread=new Thread(()->{
            Helper.getLast(vector);
        });

        Thread thread1=new Thread(()->{
            Helper.removeLast(vector);
        });

        Thread thread2=new Thread(()->{
            Helper.getLast(vector);
        });

        Thread thread3=new Thread(()->{
            Helper.removeLast(vector);
        });

        Thread thread4=new Thread(()->{
            Helper.getLast(vector);
        });

        Thread thread5=new Thread(()->{
            Helper.removeLast(vector);
        });

        thread.start();
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        Thread.sleep(5000);
        for (Integer x:vector) System.out.println(x);
    }
}


