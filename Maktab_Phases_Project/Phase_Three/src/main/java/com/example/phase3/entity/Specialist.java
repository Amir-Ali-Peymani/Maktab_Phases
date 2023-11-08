package com.example.phase3.entity;


import com.example.phase3.enumeration.SpecialistStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Specialist {

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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "profile_picture")
    private byte[] profilePicture;

    @Enumerated(EnumType.STRING)
    private SpecialistStatus specialistStatus;

    @OneToOne(mappedBy = "specialist")
    private Credit credit;

    @OneToMany(mappedBy = "specialist", cascade = CascadeType.ALL)
    private List<Proposal> proposals;

    @OneToMany(mappedBy = "specialist")
    private List<Order> orders;

    @ManyToMany
    @JoinColumn(name = "specialist_id")
    private List<SubService> subServices;
}