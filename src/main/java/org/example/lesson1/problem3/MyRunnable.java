package org.example.lesson1.problem3;

public class MyRunnable implements Runnable{
    private static int counter = 0; // shared resource

    @Override
    public void run() {
        for(int i=0 ; i<10_000_000 ; i++) counter++;
    }

    public static int getCounter() {
        return counter;
    }
}
