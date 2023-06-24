package com.example.ticketservice.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="Vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String businessLicense;

    @OneToMany(mappedBy = "vendor")
    private final List<Venue> venues = new ArrayList<>();

    @Builder
    public Vendor(String name, String email, String password, String businessLicense) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.businessLicense = businessLicense;
    }

    public void addVenue(Venue venue) {
        venues.add(venue);
    }
}
