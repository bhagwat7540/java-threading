package org.example.lesson5.problem2;

public class DoubleCheckedLocking {

    private static volatile boolean initialised = false;
    private static volatile int count = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            doThis();
        });

        Thread t2 = new Thread(()->{
            doThis();
        });
    }

    private static void doThis() {
        if(!initialised) {
            synchronized (lock) {
                if(!initialised) {
                    initialised = true;
                    count = 100;
                }
            }
        }
    }

    public synchronized int getCount() {
        return count;
    }
}
