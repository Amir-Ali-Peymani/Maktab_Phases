package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "specialist_id", nullable = false)
    private Specialist specialist;

    private double proposedPrice;

    private Date startTime;

    private int duration;
}
