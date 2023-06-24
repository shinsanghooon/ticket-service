package com.example.ticketservice.controller;

import com.example.ticketservice.model.dto.BookingRequest;
import com.example.ticketservice.model.dto.BookingResponse;
import com.example.ticketservice.service.BookingService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/booking")
public class BookingController {

    private final BookingService bookingService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void bookPerformance(@RequestBody BookingRequest bookingRequest) {
        bookingService.book(bookingRequest);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<BookingResponse> getMyBookings() {
        return bookingService.getMyBookings();
    }




}
