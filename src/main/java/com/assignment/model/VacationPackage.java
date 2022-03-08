package com.assignment.model;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name="VacationPackage")
public class VacationPackage {
    @Id
    String id;

    @ManyToOne()
    @JoinColumn(nullable = false)
    Destination destination;

    @Column(unique = true, nullable = false)
    String name;

    @Column(nullable = false)
    String price;

    @Column(nullable = false)
    String period;

    @Column(nullable = false)
    String details;

    @Column(nullable = false)
    String status;

    @Column(nullable = false)
    int seats;

    @ManyToMany(cascade = CascadeType.ALL)
    Set<User> participants;
    public VacationPackage() {
    }

    public VacationPackage(String id, String name, String price, String period, String details, String status, int seats) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.period = period;
        this.details = details;
        this.status = status;
        this.seats = seats;
    }
}
