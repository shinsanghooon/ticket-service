package com.example.ticketservice.model.dto;

import com.example.ticketservice.common.SeatStatus;
import com.example.ticketservice.repository.entity.PerformanceSeats;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PerformanceSeatResponse {

    private String gradeName;

    private String seatNumber;

    private Long price;

    private SeatStatus seatStatus;

    public static List<PerformanceSeatResponse>  fromEntity(List<PerformanceSeats> performanceSeats) {
        return performanceSeats.stream()
            .map(s -> PerformanceSeatResponse.builder()
                .gradeName(s.getGrade().getName())
                .seatNumber(s.getSeat().getName())
                .seatStatus(s.getSeatStatus())
                .price(s.getGrade().getPrice())
                .build())
            .collect(Collectors.toList());

    }
}
