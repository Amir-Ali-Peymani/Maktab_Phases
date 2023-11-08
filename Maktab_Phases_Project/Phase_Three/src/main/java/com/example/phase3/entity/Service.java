package com.example.phase3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "service")
    private Set<SubService> subServices;

}