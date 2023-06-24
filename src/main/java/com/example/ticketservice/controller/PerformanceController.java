package com.example.ticketservice.controller;

import com.example.ticketservice.model.dto.PerformanceResponse;
import com.example.ticketservice.model.dto.PerformanceSeatsResponse;
import com.example.ticketservice.service.PerformanceService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/performance")
public class PerformanceController {

    private final PerformanceService performanceService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    public PerformanceResponse getById(@PathVariable("id") Long id) {
        return performanceService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Map<String, List<PerformanceResponse>> getById(@Param("name") String name) {
        return performanceService.getByName(name);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}/seats")
    public PerformanceSeatsResponse getWithSeatStatusById(@PathVariable("id") Long id) {
        return performanceService.getPerformanceSeatsById(id);
    }

}
