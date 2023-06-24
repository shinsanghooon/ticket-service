
package com.example.ticketservice.repository;

import com.example.ticketservice.repository.entity.Performance;
import com.example.ticketservice.repository.entity.PerformanceSeats;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerformanceSeatsRepository extends JpaRepository<PerformanceSeats, Long> {

}
