package example.thread_create;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Watch_Using_Thread {

    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                printWatch();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Logger.getLogger(Watch_Using_Thread.class.getName()).log(Level.SEVERE, null, e);
                    Thread.currentThread().interrupt();
                    throw new AssertionError(e);
                }
            }
        });
        t.start();
    }

    private static void printWatch() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:s a");
        String formattedTime = LocalDateTime.now().format(formatter);
        System.out.println(formattedTime);
    }
}
