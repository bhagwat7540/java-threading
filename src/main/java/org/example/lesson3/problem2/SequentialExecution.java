package org.example.lesson3.problem2;

public class SequentialExecution {
    public static void main(String[] args) {
        System.out.println("Main Started");
        Thread t1 = new Thread(() -> {
            System.out.println("Thread1 running");
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join();
                System.out.println("Thread2 running");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                t2.join();
                System.out.println("Thread3 running");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t3.join();
            System.out.println("Main ends");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
