
package example.thread_terminating;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Thread_Termination {
    static boolean flag=true;
    static boolean flag1=true;
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
           while(flag){
                System.out.println("Into "+Thread.currentThread().getName());
               try {
                   Thread.sleep(500);
               } catch (InterruptedException ex) {
                   Logger.getLogger(Thread_Termination.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
        });
        
        Thread t1=new Thread(()->{
            while(flag1){
                System.out.println("Into "+Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Thread_Termination.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        t.start();
        t1.start();
        
        Thread.sleep(4000);
        stop();
        Thread.sleep(3000);
        stop1();
        System.out.println("Initialization finished");
    }
    private  static void stop(){
        flag=false;
    }
    private  static void stop1(){
        flag1=false;
    }
}


