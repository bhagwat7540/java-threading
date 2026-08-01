package org.example.lesson2.problem3;

public class Main {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            synchronized (lock) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "Sleep Thread");

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("got lock!");
            }
        }, "Blocked Thread");

        t.start();
        Thread.sleep(1000);
        t1.start();

        BlockedThreadDetector detector = new BlockedThreadDetector(1000);
        for(int i=0 ; i<5 ; i++) {
            Thread.sleep(1000);
            System.out.println("Check - " + (i+1));
            detector.detect();
        }
    }
}
