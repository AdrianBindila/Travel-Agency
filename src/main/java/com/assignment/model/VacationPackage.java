package com.assignment.model;

import com.assignment.service.VacationStatus;
import javafx.util.Pair;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.StringTokenizer;

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
    public VacationPackage(Integer id,Destination destination, String name, String price, String period, String details, int seats) {
        this.vacation_id = id;
        this.destination = destination;
        this.name = name;
        this.price = price;
        this.period = period;
        this.details = details;
        this.status = VacationStatus.NOT_BOOKED.label;
        this.seats = seats;
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

    public Integer getId() {
        return vacation_id;
    }

    public String getName() {
        return name;
    }

    public Set<User> getParticipants() {
        return participants;
    }

    public Destination getDestination() {
        return destination;
    }

    public String getPrice() {
        return price;
    }

    public String getPeriod() {
        return period;
    }

    public Pair<Date, Date> getDatesFromPeriod() {
        StringTokenizer stringTokenizer = new StringTokenizer(this.period, " / ");
        Date dateFrom = new Date();
        Date dateTo = new Date();
        try {
            dateFrom = new SimpleDateFormat("yyyy-MM-dd").parse(stringTokenizer.nextToken());
            dateTo = new SimpleDateFormat("yyyy-MM-dd").parse(stringTokenizer.nextToken());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Pair<>(dateFrom, dateTo);
    }

    public String getDetails() {
        return details;
    }

    public String getStatus() {
        return status;
    }

    public int getSeats() {
        return seats;
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
