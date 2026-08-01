package org.example.lesson2.problem2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StateStatistics {

    private static volatile boolean running = true;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(new Thread(() -> {
                while (running) {
                    for (int j = 0; j < 10_000_000; j++) {
                    }
                }
            }, "Worker-" + i));
        }

        for (int i = 0; i < 3; i++) {
            list.add(new Thread(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }, "Sleeper-" + i));
        }

        for (int i = 0; i < 3; i++) {
            list.add(new Thread(() -> {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }, "waiter-" + i));
        }

        list.forEach(Thread::start);

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);

            Map<Thread.State, Long> map = list.stream().collect(Collectors.groupingBy(Thread::getState, Collectors.counting()));
            System.out.println("Second - " + (i+1) + "====");
            for(Thread.State state : map.keySet()) {
                long count = map.get(state);
                if(count > 0) {
                    System.out.println("State - " + state + " Count - " + count);
                }
            }
        }

        running = false;
        synchronized (lock) {
            lock.notifyAll();
        }
    }
}
