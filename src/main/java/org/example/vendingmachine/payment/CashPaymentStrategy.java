package org.example.vendingmachine.payment;

public class CashPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("Paid using Cash");
    }
}
