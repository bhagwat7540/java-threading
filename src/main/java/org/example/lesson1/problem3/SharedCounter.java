package org.example.lesson1.problem3;

public class SharedCounter {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new MyRunnable());
        Thread t2 = new Thread(new MyRunnable());
        Thread t3 = new Thread(new MyRunnable());

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(MyRunnable.getCounter());
    }
}
