package com.example.phase3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "balance", nullable = false)
    private double balance;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}