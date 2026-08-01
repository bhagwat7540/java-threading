package org.example.lesson2.problem3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BlockedThreadDetector {
    private final long threshold;
    private final Map<Long, Long> map ;

    public BlockedThreadDetector(long threshold) {
        this.threshold = threshold;
        map = new HashMap<>();
    }

    public List<Thread> detect() {
        List<Thread> list = new ArrayList<>();
        for(Thread t : Thread.getAllStackTraces().keySet()) {
            if(t.getState() == Thread.State.BLOCKED) {
                map.putIfAbsent(t.threadId(), System.currentTimeMillis());

                long duration = System.currentTimeMillis() - map.get(t.threadId());
                if(duration > threshold) {
                    list.add(t);
                    System.out.println("Thread - " + t.getName() + " blocked for - " + duration);
                }
            }
            else {
                list.remove(t.threadId());
            }
        }

        return list;
    }

}
