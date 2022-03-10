package com.assignment.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Destination")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "destination")
    private Set<VacationPackage> vacationPackages;

    public Destination() {
    }

    public Destination(String name) {
        this.id = null;
        this.name = name;
    }

    public Destination(String name, Set<VacationPackage> vacationPackages) {
        this.id = null;
        this.name = name;
        this.vacationPackages = vacationPackages;
    }
}
