package org.example.vendingmachine.payment;

public class CardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay() {
        System.out.println("Paid using Card");
    }
}
