package com.cropdeal.payment_service.dto;

public class PaymentResponse {
    private String message;
    private String transactionId;

    public PaymentResponse(String paymentSuccessful, String s) {
        this.message = paymentSuccessful;
        this.transactionId = s;
    }
}
