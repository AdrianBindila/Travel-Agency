package com.assignment.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "VacationPackage")
public class VacationPackage {
    @ManyToMany(cascade = CascadeType.ALL)
    Set<User> participants;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ManyToOne()
    @JoinColumn(nullable = false)
    private Destination destination;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private String price;
    @Column(nullable = false)
    private String period;
    @Column(nullable = false)
    private String details;

    public String getName() {
        return name;
    }

    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private int seats;

    public VacationPackage() {
    }

    public VacationPackage(Destination destination, String name, String price, String period, String details, String status, int seats) {
        this.id = 0;
        this.destination = destination;
        this.name = name;
        this.price = price;
        this.period = period;
        this.details = details;
        this.status = status;
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "VacationPackage{" +
                "participants=" + participants +
                ", id=" + id +
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
