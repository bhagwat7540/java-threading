package org.example.lesson6.problem1;

import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Thread - " + Thread.currentThread().getName());

                synchronized (lock) {
                    System.out.println("Inner thread - " + Thread.currentThread().getName());
                }
            }
        }, "Worker Thread");

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
