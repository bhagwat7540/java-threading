package org.example.Idempotency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PaymentService {

    private final Map<String, PaymentResponse> map = new ConcurrentHashMap<>();

    public PaymentResponse charge(PaymentRequest request) {
        map.computeIfAbsent(request.idempotencyKey, k-> {
            System.out.println("Inside map");
            return  new PaymentResponse("200");
        });

        return map.get(request.idempotencyKey);
    };
}
