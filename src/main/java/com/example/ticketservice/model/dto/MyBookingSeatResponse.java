package com.example.ticketservice.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

public class MyBookingSeatResponse {

    private String gradeName;

    private String seatNumber;

}
