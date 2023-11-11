package com.example.phase3.entity;

import com.example.phase3.enumeration.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double proposedPrice;

    private String jobDescription;

    private Date date;

    @Column
    private double finalPrice;

    @Column
    private Date compeletionDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subService_id")
    private SubService subService;

    @OneToMany(mappedBy = "order")
    private List<Proposal> proposals;

    @OneToMany(mappedBy = "order")
    private List<Review> reviews;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
