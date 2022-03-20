package com.assignment.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "User", uniqueConstraints = {@UniqueConstraint(columnNames = {"email", "username"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer user_id;

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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "User_VacationPackage",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "vacation_id")},
            uniqueConstraints = @UniqueConstraint(columnNames = {"user_id","vacation_id"})
    )
    private Set<VacationPackage> vacationPackages = new HashSet<>();

    public User() {
    }

    public User(String email, String username, String password, String firstName, String lastname) {
        this.user_id = null;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public User(String email, String username, String password, String firstName, String lastname, Set<VacationPackage> bookings) {
        this.user_id = null;
        this.email = email;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastname = lastname;
    }

    public Integer getId() {
        return user_id;
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

    public Set<VacationPackage> getVacationPackages() {
        return vacationPackages;
    }

}
