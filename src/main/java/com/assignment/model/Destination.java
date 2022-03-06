package com.assignment.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "Destination")
public class Destination {
    @Id
    String id;
    @Column
    String name;
    @OneToMany(mappedBy = "destination")
    Set<VacationPackage> vacationPackages;

    public Destination() {
    }

    public Destination(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Destination(String id, String name, Set<VacationPackage> vacationPackages) {
        this.id = id;
        this.name = name;
        this.vacationPackages = vacationPackages;
    }
}
