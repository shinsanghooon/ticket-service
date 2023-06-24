package com.example.ticketservice.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Getter
@NoArgsConstructor
@Table(name="BookingSeats")
public class BookingSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long performanceSeatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @Builder
    public BookingSeat(Long performanceSeatId, Booking booking) {
        this.performanceSeatId = performanceSeatId;
        this.booking = setBooking(booking);
    }

    private Booking setBooking(Booking booking) {
        if (this.booking != null) {
            this.booking.getBookingSeats().remove(this);
        }
        this.booking = booking;
        booking.addBookingSeat(this);
        return booking;
    }
}
