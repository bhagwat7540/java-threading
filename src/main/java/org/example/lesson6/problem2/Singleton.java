package org.example.lesson6.problem2;

public class Singleton {
    private Singleton(){}

    private static class Holder { // Initialised only when first called
        private static final Singleton obj = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.obj;
    }

    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();
    }
}
