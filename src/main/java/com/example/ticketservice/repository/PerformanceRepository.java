package com.example.ticketservice.repository;

import com.example.ticketservice.repository.entity.Performance;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceRepository extends JpaRepository<Performance, Long> {

    List<Performance> findByName(String name);
}
