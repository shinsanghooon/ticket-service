package com.example.ticketservice.model.dto;

import com.example.ticketservice.common.SeatStatus;
import com.example.ticketservice.repository.entity.Performance;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PerformanceSeatsResponse {

    private Long id;

    private String name;

    private LocalDateTime date;

    private int startTime;

    private int endTime;

    private long allSeatCount;

    private long availableSeatCount;

    private List<PerformanceSeatResponse> availableSeats;

    public static PerformanceSeatsResponse fromEntity(Performance performance) {

        long availableSeatCount = performance.getPerformanceSeats().stream()
            .filter(s -> s.getSeatStatus().equals(SeatStatus.AVAILABLE))
            .count();

        return PerformanceSeatsResponse.builder()
            .id(performance.getId())
            .name(performance.getName())
            .date(performance.getDate())
            .startTime(performance.getStartTime())
            .endTime(performance.getEndTime())
            .allSeatCount(performance.getPerformanceSeats().size())
            .availableSeatCount(availableSeatCount)
            .availableSeats(PerformanceSeatResponse.fromEntity(performance.getPerformanceSeats()))
            .build();
    }


}
