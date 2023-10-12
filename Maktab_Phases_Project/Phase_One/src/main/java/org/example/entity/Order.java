package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Entity
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

    @Column(nullable = true)
    private double finalPrice;

    @Column(nullable = true)
    private Date compeletionDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(optional = true)
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    @ManyToOne
    @JoinColumn(name = "subService_id")
    private SubService subService;

    @OneToMany(mappedBy = "specialist")
    private List<Proposal> proposals;


    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

}
