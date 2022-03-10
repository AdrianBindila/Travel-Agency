package com.assignment.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "username"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastname;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "participants")
    private Set<VacationPackage> bookings;
    @ManyToMany(mappedBy = "participants")
    private Collection<VacationPackage> vacationPackages;

    public User() {
    }

    public User(String email, String username, String password, String firstName, String lastname) {
        this.id = null;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public User(String email, String username, String password, String firstName, String lastname, Set<VacationPackage> bookings) {
        this.id = null;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
        this.bookings = bookings;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public Collection<VacationPackage> getVacationPackages() {
        return vacationPackages;
    }

    public void setVacationPackages(Collection<VacationPackage> vacationPackages) {
        this.vacationPackages = vacationPackages;
    }
}
