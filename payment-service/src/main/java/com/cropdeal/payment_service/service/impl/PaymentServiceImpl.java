package com.cropdeal.payment_service.service.impl;

import com.cropdeal.payment_service.dto.PaymentRequest;
import com.cropdeal.payment_service.dto.PaymentResponse;
import com.cropdeal.payment_service.entity.Payment;
import com.cropdeal.payment_service.event.EventPublisher;
import com.cropdeal.payment_service.event.PaymentEvent;
import com.cropdeal.payment_service.repository.PaymentRepository;
import com.cropdeal.payment_service.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private EventPublisher eventPublisher;

    @Override
    public PaymentResponse processPayment(PaymentRequest request) {
        Payment payment = new Payment();
        payment.setFarmerId(request.getFarmerId());
        payment.setDealerId(request.getDealerId());
        payment.setAmount(request.getAmount());
        payment.setStatus("SUCCESS");
        payment.setTimestamp(LocalDateTime.now());

        paymentRepo.save(payment);  // ✅ Saving Payment, not PaymentRequest

        eventPublisher.publish(new PaymentEvent(payment.getId(), "PAYMENT_SUCCESS"));

        return new PaymentResponse("Payment successful", String.valueOf(payment.getId()));
    }
}
