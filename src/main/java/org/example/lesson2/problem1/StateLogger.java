package org.example.lesson2.problem1;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class StateLogger {
    public static void main(String[] args) throws InterruptedException {
        Thread workerThread = new Thread(() -> {
            try {
                Thread.sleep(100);
                synchronized (StateLogger.class) {
                    StateLogger.class.wait(100
                    );
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "WorkerThread");

        monitorThread(workerThread);
        workerThread.start();
        workerThread.join();
    }

    private static void monitorThread(Thread target) {
        Thread t = new Thread(() -> {
            Thread.State prevState = null;

            while(true) {
                Thread.State currentState = target.getState();

                if(currentState != prevState) {

                    System.out.printf("[%s] Thread - %s : %s -> %s%n",
                            LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss.SSS")),
                            target.getName(),
                            prevState == null ? "CREATED" : prevState,
                            currentState);

                    prevState = currentState;

                }

                if(currentState == Thread.State.TERMINATED) break;
            }
        }, "StateLogger");

        t.setDaemon(true);
        t.start();
    }
}
