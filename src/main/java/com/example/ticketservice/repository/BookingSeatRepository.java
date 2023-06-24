package com.example.ticketservice.repository;

import com.example.ticketservice.repository.entity.Booking;
import com.example.ticketservice.repository.entity.BookingSeat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingSeatRepository extends JpaRepository<BookingSeat, Long> {

    List<BookingSeat> findByBooking(Booking booking);

}
