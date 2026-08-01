package org.example.lesson1.problem1;

public class ThreadCreation {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread(()-> {
            for(int i=1 ; i<=10 ; i++) {
                System.out.println("Lambda : " + i);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
