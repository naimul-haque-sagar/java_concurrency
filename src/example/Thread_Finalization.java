package example;

public class Thread_Finalization {
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
                printfib();
        });
        thread.start();
        thread.join();
        System.out.println("Thread end");
    }

    private static void printfib() {
        for (int i=1;i<40;i++){
            System.out.println(fib(i));
        }
    }

    private static int fib(int i) {
        if(i==1 || i ==2){
            return i;
        }
        return fib(i-1)+fib(i-2);
    }
}
