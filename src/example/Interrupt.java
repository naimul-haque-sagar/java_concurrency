package example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Interrupt {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (true) {
                doJob();
                if (Thread.interrupted()) {
                    System.out.println("Interrupted");
                    return;
                }
            }
        });
        t.start();
        Thread.sleep(500);
        //if target method is never sleep or wait state interrupt will never work
        //it will only change the flag variable value
        t.interrupt();
    }

    private static void doJob() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:s a");
        String ans = LocalDateTime.now().format(df);
        System.out.println(ans);
    }
}
