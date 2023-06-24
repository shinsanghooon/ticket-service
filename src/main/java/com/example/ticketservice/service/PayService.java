package com.example.ticketservice.service;

import com.example.ticketservice.model.dto.PaymentInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PayService {

    public void payForTickets(PaymentInfo paymentInfo, Long price) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
