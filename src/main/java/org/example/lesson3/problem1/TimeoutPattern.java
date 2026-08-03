package org.example.lesson3.problem1;

public class TimeoutPattern {
    private static String fetchFromUrl(String defaultValue) {
        String[] result = {null};
        Thread t = new Thread(() -> {
            result[0] =  fetch();
        });

        t.start();
        try {
            t.join(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }

        if(t.isAlive()) return defaultValue;
        return result[0];
    }

    private static String fetch() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return null;
        }

        return "DATA";
    }

    public static void main(String[] args) {
        System.out.println(fetchFromUrl("DEFAULT"));
    }
}
