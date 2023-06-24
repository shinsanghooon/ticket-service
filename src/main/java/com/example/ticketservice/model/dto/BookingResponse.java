package com.example.ticketservice.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BookingResponse {

    public Long performanceId;

    public String performanceName;

    private LocalDateTime date;

    private int startTime;

    private int endTime;

    public List<MyBookingSeatResponse> seats;

}
