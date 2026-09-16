package org.example.atm.cash;

import java.util.Map;

public abstract class NoteHandler {
    private NoteHandler next;
    private int count;
    private int value;

    public NoteHandler(int count, int value) {
        this.count = count;
        this.value = value;
    }

    public NoteHandler setNext(NoteHandler next) {
        this.next = next;
        return next;
    }

    public void refill(int more) { count += more; }

    public boolean plan(int amount, Map<Integer, Integer> out) {
        int use = (int) Math.min(amount / value, count);
        if (use > 0) out.put(value, use);
        int remaining = amount - use * value;
        if (remaining == 0) return true;
        if (next != null) return next.plan(remaining, out);
        return false;
    }
    public void commit(Map<Integer, Integer> plan) {
        count -= plan.getOrDefault(value, 0);
        if (next != null) next.commit(plan);
    }
}
