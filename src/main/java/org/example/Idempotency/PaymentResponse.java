package org.example.Idempotency;

public class PaymentResponse {
    String responseCode;

    public PaymentResponse(String responseCode) {
        this.responseCode = responseCode;
    }
}
