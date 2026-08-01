package org.example.lesson1.problem4;

public class Interleave {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for(int i=1 ; i<10_000_000 ; i+=2) System.out.println(i);
        });

        Thread t2 = new Thread(() -> {
            for(int i=2 ; i<10_000_000 ; i+=2) System.out.println(i);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
