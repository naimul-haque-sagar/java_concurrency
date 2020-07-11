package example;

public class Yield_Method2 extends Thread {
    public static void main(String[] args) {
        Yield_Method2 yield_method2=new Yield_Method2();
        Yield_Method2 yield_method21=new Yield_Method2();
        yield_method2.start();
        yield_method21.start();
        for (int i=0; i<3; i++)
        {
            yield_method2.yield();
            System.out.println(Thread.currentThread().getName());
        }
    }

    public void run()
    {
        for (int i=0; i<3 ; i++)
            System.out.println(Thread.currentThread().getName());
    }
}
