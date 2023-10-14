package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
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

    @OneToMany(mappedBy = "specialist")
    private List<Proposal> proposals;

    @OneToMany(mappedBy = "specialist")
    private List<Order> orders;

    @ManyToMany
    @JoinColumn(name = "subService_id")
    private List<SubService> subServices;
}
