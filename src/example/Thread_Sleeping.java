package example;

public class Thread_Sleeping {
    private static boolean flag=true;
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
           while(flag){
               System.out.println("Hello");
           }
        });
        thread.start();
        Thread.sleep(5000);
        terminator();
    }

    static void terminator(){
        flag=false;
    }
}
