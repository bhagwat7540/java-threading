package org.example.lesson4;

import java.time.LocalTime;

public class Logger {
    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while(true) {
                System.out.println("[LOG] : " + LocalTime.now().toString());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("JVM exiting");
    }
}
