package com.example.phase3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SubService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private double basePrice;

    @Column(nullable = false)
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToMany(mappedBy = "subServices")
    private List<Specialist> specialist;

    @OneToMany(mappedBy = "subService")
    private List<Order> orderList;

}
