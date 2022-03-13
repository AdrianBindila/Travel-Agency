package com.assignment.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer destination_id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "destination", cascade = CascadeType.MERGE)
    private Set<VacationPackage> vacationPackages;

    public Destination() {
    }

    public Destination(String name) {
        this.destination_id = null;
        this.name = name;
    }

    public Destination(String name, Set<VacationPackage> vacationPackages) {
        this.destination_id = null;
        this.name = name;
        this.vacationPackages = vacationPackages;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return this.destination_id;
    }
}
