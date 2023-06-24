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
@Table(name="Venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int capacity;

    @Column
    private String description;

    @OneToMany(mappedBy = "venue")
    private final List<Performance> performances = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    @OneToMany(mappedBy = "venue")
    private final List<Seat> seats = new ArrayList<>();

    @Builder
    public Venue(String name, int capacity, String description, Vendor vendor) {
        this.name = name;
        this.capacity = capacity;
        this.description = description;
        this.vendor = setVendor(vendor);
    }

    public void addPerformance(Performance performance) {
        performances.add(performance);
    }

    private Vendor setVendor(Vendor vendor) {
        if (this.vendor != null) {
            this.vendor.getVenues().remove(this);
        }
        this.vendor = vendor;
        vendor.addVenue(this);

        return vendor;
    }

    public void addSeat(Seat seat) {
        seats.add(seat);
    }

}
