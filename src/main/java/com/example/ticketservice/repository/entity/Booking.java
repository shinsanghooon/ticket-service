package com.example.ticketservice.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @OneToMany(mappedBy = "booking")
    private List<BookingSeat> bookingSeats = new ArrayList<>();

    @Column
    private Long totalPayment;


    @Builder
    public Booking(User user, Performance performance,
        Long totalPayment) {
        this.user = setUser(user);
        this.performance = setPerformance(performance);
        this.totalPayment = totalPayment;
    }

    private User setUser(User user) {
        if (this.user != null) {
            this.user.getBookings().remove(this);
        }
        this.user = user;
        user.addBooking(this);
        return user;
    }

    private Performance setPerformance(Performance performance) {
        if (this.performance != null) {
            this.performance.getBookings().remove(this);
        }
        this.performance = performance;
        performance.addBooking(this);
        return performance;
    }

    public void addBookingSeat(BookingSeat bookingSeat) {
        bookingSeats.add(bookingSeat);
    }


}
