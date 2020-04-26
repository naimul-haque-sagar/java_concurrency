package example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThreadTermination {

    public static void main(String[] args) throws InterruptedException {
        MyThread m = new MyThread("First");
        MyThread m1 = new MyThread("second");
        Thread.sleep(4000);
        m.stop();
        Thread.sleep(3000);
        m1.stop();
        Thread.sleep(1000);
    }
}

class MyThread implements Runnable {

    private boolean flag;
    Thread t;
    String name;

    public MyThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        flag = false;
        t.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (!flag) {
            i++;
            System.out.println(name + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println(name + " " + "stopped");
    }

    public void stop() {
        this.flag = true;
    }
}
