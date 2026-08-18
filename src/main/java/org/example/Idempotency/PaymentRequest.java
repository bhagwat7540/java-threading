package org.example.Idempotency;

public class PaymentRequest {
    String accountId;
    int amount;
    String idempotencyKey;

    public PaymentRequest(String accountId, int amount, String idempotencyKey) {
        this.accountId = accountId;
        this.amount = amount;
        this.idempotencyKey = idempotencyKey;
    }
}
