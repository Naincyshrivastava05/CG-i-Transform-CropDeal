package com.cropdeal.payment_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {
    public Long getFarmerId;
    private  Long farmerId;
    private  Long dealerId;
    private Double amount;
}
