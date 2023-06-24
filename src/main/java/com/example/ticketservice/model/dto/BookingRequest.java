package com.example.ticketservice.model.dto;

import com.example.ticketservice.repository.entity.Booking;
import com.example.ticketservice.repository.entity.Performance;
import com.example.ticketservice.repository.entity.User;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookingRequest {

    private Long performanceId;

    private List<Long> performanceSeatIds;

    private Long totalPrice;

    private PaymentInfo paymentInfo;

    public Booking toEntity(User user, Performance performance) {
        return Booking.builder()
            .user(user)
            .performance(performance)
            .totalPayment(this.totalPrice)
            .build();
    }

}
