package com.cropdeal.payment_service.controller;

import com.cropdeal.payment_service.dto.PaymentRequest;
import com.cropdeal.payment_service.dto.PaymentResponse;
import com.cropdeal.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
        @Autowired
    private PaymentService paymentService;

        @PostMapping
    public ResponseEntity<PaymentResponse> makePayment(@RequestBody PaymentRequest request){
            return ResponseEntity.ok(paymentService.processPayment(request));
        }
    @GetMapping
    public ResponseEntity<String> getPayments() {
        return ResponseEntity.ok("Payments service is running!");
    }
}
