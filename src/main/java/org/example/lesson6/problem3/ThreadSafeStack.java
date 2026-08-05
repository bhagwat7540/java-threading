package org.example.lesson6.problem3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class ThreadSafeStack {
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Object lock = new Object();

    public void push(int i) {
        synchronized (lock) {
            stack.push(i);
        }
    }

    public int pop() {
        synchronized (lock) {
            if(stack.isEmpty()) {
                throw new NoSuchElementException("Stack is Empty");
            }

            return stack.pop();
        }
    }

    public boolean isEmpty() {
        synchronized (lock) {
            return stack.isEmpty();
        }
    }

    public int size() {
        synchronized (lock) {
            return stack.size();
        }
    }

    public int peek() {
        synchronized (lock) {
            return stack.peek();
        }
    }
}
