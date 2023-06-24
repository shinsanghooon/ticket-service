package com.example.ticketservice.service;

import static java.util.stream.Collectors.groupingBy;

import com.example.ticketservice.model.dto.PerformanceResponse;
import com.example.ticketservice.model.dto.PerformanceSeatsResponse;
import com.example.ticketservice.repository.PerformanceRepository;
import com.example.ticketservice.repository.entity.Performance;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PerformanceService {

    private final PerformanceRepository performanceRepository;

    public Map<String, List<PerformanceResponse>> getByName(String name) {
        List<Performance> performances = performanceRepository.findByName(name);
        return  performances.stream()
            .map(PerformanceResponse::fromEntity)
            .collect(groupingBy(PerformanceResponse::getName));
    }

    public PerformanceResponse getById(Long id) {
        return PerformanceResponse.fromEntity(findById(id));
    }

    public PerformanceSeatsResponse getPerformanceSeatsById(Long id) {
        return PerformanceSeatsResponse.fromEntity(findById(id));
    }

    public Performance findById(Long id) {
        return performanceRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("해당 공연 정보를 찾을 수 없습니다."));
    }
}
