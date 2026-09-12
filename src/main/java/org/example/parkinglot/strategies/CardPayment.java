package org.example.parkinglot.strategies;

public class CardPayment implements PaymentStrategy{
    @Override
    public boolean pay(int amount) {
        //gateway.charge(amount)
        return true;
    }
}
