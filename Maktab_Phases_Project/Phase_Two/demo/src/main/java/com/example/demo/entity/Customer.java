package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name= "firstName", nullable = false)
    private String firstName;

    @Column(name= "lastName", nullable = false)
    private String lastName;

    @Column(name= "email", nullable = false, unique = true)
    private String email;

    @Column(name= "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "customer")
    private Credit credit;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Order> orders;

    @OneToMany(mappedBy = "customer")
    private Set<Review> reviews;

}
