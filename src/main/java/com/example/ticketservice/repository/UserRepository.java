package com.example.ticketservice.repository;

import com.example.ticketservice.repository.entity.Booking;
import com.example.ticketservice.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
