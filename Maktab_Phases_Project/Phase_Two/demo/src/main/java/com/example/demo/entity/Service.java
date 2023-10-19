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
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    private Set<SubService> subServices;


}
