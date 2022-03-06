package com.assignment.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="User")
public class User {
    @Id
    private String id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastname;

    @ManyToMany(cascade = CascadeType.ALL)

    private Set<VacationPackage> bookings;

    public User() {
    }
    public User(String id, String email, String username, String password, String firstName, String lastname) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
    }
    public User(String id, String email, String username, String password, String firstName, String lastname, Set<VacationPackage> bookings) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.bookings = bookings;
    }

    @ManyToMany(mappedBy = "participants")
    private Collection<VacationPackage> vacationPackages;

    public Collection<VacationPackage> getVacationPackages() {
        return vacationPackages;
    }

    public void setVacationPackages(Collection<VacationPackage> vacationPackages) {
        this.vacationPackages = vacationPackages;
    }
}
