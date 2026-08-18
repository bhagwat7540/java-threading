package org.example.Idempotency;

public class main {
    public static void main(String[] args) throws InterruptedException {
        PaymentService service = new PaymentService();
        service.charge(new PaymentRequest("acc1", 100, "abc"));

        Thread t1 = new Thread(()-> {
            service.charge(new PaymentRequest("acc1", 100, "abc"));
        });

        Thread t2 = new Thread(()-> {
            service.charge(new PaymentRequest("acc1", 100, "abc"));
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
