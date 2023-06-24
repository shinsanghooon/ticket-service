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
@Table(name="Seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany(mappedBy = "seat")
    private List<PerformanceSeats> performanceSeats = new ArrayList<>();

    @Builder
    public Seat(String name, Venue venue) {
        this.name = name;
        this.venue = setVenue(venue);
    }

    private Venue setVenue(Venue venue) {
        if (this.venue != null) {
            this.venue.getPerformances().remove(this);
        }
        this.venue = venue;
        venue.addSeat(this);
        return venue;
    }


}
