package example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ThreadInterrupt {

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
        Thread.sleep(1500);
        t.interrupt();
    }

    private static void doJob() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:s a");
        String ans = LocalDateTime.now().format(df);
        System.out.println(ans);
    }
}
