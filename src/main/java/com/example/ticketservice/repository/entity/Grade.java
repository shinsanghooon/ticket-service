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
import org.aspectj.weaver.patterns.PerFromSuper;

@Entity
@Getter
@NoArgsConstructor
@Table(name="Grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "performance_id")
    private Performance performance;

    @OneToMany(mappedBy = "grade")
    private List<PerformanceSeats> performanceSeats = new ArrayList<>();

    @Builder
    public Grade(String name, Long price, Performance performance) {
        this.name = name;
        this.price = price;
        this.performance = setPerformance(performance);
    }

    private Performance setPerformance(Performance performance) {
        if (this.performance != null) {
            this.performance.getGrades().remove(this);
        }
        this.performance = performance;
        performance.addGrade(this);
        return performance;
    }
}
