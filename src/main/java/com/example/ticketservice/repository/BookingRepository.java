package com.example.ticketservice.repository;

import com.example.ticketservice.repository.entity.Booking;
import com.example.ticketservice.repository.entity.Performance;
import com.example.ticketservice.repository.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUser(User user);
}
