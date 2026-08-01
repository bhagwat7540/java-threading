package org.example.lesson1.problem2;

public class ThreadInformation {
    public static void main(String[] args) {
        Thread t1 = Thread.currentThread();
        System.out.println("Name = " + t1.getName() + " id = " + t1.threadId() + " priority = " + t1.getPriority()
                + " state = " + t1.getState()
                + " alive = " + t1.isAlive() + " Daemon = " + t1.isDaemon());

    }
}
