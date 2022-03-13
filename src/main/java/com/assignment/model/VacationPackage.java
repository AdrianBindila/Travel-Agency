package com.assignment.model;

import com.assignment.service.VacationStatus;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "VacationPackage")
public class VacationPackage {
    @ManyToMany(cascade = CascadeType.ALL)
    Set<User> participants;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer vacation_id;
    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String period;
    @Column
    private String details;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private int seats;
    public VacationPackage() {
    }

    public VacationPackage(Destination destination, String name, String price, String period, String details, int seats) {
        this.vacation_id = 0;
        this.destination = destination;
        this.name = name;
        this.price = price;
        this.period = period;
        this.details = details;
        this.status = VacationStatus.NOT_BOOKED.label;
        this.seats = seats;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "VacationPackage{" +
                "participants=" + participants +
                ", id=" + vacation_id +
                ", destination=" + destination +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", period='" + period + '\'' +
                ", details='" + details + '\'' +
                ", status='" + status + '\'' +
                ", seats=" + seats +
                '}';
    }
}
