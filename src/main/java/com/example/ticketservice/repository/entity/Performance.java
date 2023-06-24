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
import java.awt.print.Book;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Performances")
public class Performance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private LocalDateTime date;

    @Column
    private int startTime;

    @Column
    private int endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany(mappedBy = "performance")
    private List<Grade> grades = new ArrayList<>();

    @OneToMany(mappedBy = "performance")
    private List<PerformanceSeats> performanceSeats = new ArrayList<>();

    @OneToMany(mappedBy = "performance")
    private List<Booking> bookings = new ArrayList<>();

    @Builder
    public Performance(String name, LocalDateTime date, int startTime, int endTime, Venue venue) {
        this.name = name;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venue = setVenue(venue);
    }

    private Venue setVenue(Venue venue) {
        if (this.venue != null) {
            this.venue.getPerformances().remove(this);
        }
        this.venue = venue;
        venue.addPerformance(this);

        return venue;
    }

    public void addGrade(Grade grade) {
        this.grades.add(grade);
    }

    public void addBooking(Booking booking) {
        this.bookings.add(booking);
    }

}
