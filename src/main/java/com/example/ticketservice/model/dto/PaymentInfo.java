package com.example.ticketservice.model.dto;

import com.example.ticketservice.common.PaymentMethod;
import lombok.Getter;

@Getter
public class PaymentInfo {

    private PaymentMethod paymentMethod;

    private String cardNumber;

    private String cardExpiration;

    private String cardCvc;

    public PaymentInfo(PaymentMethod paymentMethod, String cardNumber, String cardExpiration,
        String cardCvc) {
        this.paymentMethod = paymentMethod;
        this.cardNumber = cardNumber;
        this.cardExpiration = cardExpiration;
        this.cardCvc = cardCvc;
    }
}
