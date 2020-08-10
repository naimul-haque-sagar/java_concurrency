package example.thread_communication;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class Producer_Consumer {
    volatile static boolean p=true;
    volatile static boolean c=true;
    public static void main(String[] args) throws InterruptedException {
        BufferExample bufferExample=new BufferExample();
        Random random=new Random();

        Thread producer=new Thread(()->{
           while(p){
               int randomInt=random.nextInt();
               System.out.println(randomInt);
               bufferExample.addItem(randomInt);
               try {
                   TimeUnit.SECONDS.sleep(1);
               } catch (InterruptedException e) {
                   Thread.currentThread().interrupt();
                   throw new AssertionError(e);
               }
           }
        });
        Thread consumer=new Thread(()->{
            while(c){
                Integer item=bufferExample.getItem();
                System.out.println(item);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    new AssertionError(e);
                }
            }
        });

        producer.start();
        consumer.start();

        Thread.sleep(5000);
        p=false;
        c=false;
    }
}

class BufferExample{
    private BlockingQueue<Integer> queue=new LinkedBlockingDeque<>(10);

    public void addItem(Integer item){
        try{
            queue.put(item);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }

    public Integer getItem(){
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}
