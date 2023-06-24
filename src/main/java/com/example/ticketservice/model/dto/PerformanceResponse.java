package com.example.ticketservice.model.dto;

import com.example.ticketservice.repository.entity.Performance;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PerformanceResponse {

    private Long id;

    private String name;

    private LocalDateTime date;

    private int startTime;

    private int endTime;

    private String venue;

    private String venueDescription;

    public static PerformanceResponse fromEntity(Performance performance) {
        return PerformanceResponse.builder()
            .id(performance.getId())
            .name(performance.getName())
            .date(performance.getDate())
            .startTime(performance.getStartTime())
            .endTime(performance.getEndTime())
            .venue(performance.getVenue().getName())
            .venueDescription(performance.getVenue().getDescription())
            .build();
    }

}
