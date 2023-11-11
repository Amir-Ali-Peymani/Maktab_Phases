package com.example.phase3.dto;

import com.example.phase3.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    private long id;
    private String name;
    private String lastName;
    private String email;
    private long creditId;
    private Set<OrderDTO> orderDTOS;
    private Set<ReviewDTO> reviewDTOS;

    public static CustomerDTO fromCustomer(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getFirstName());
        customerDTO.setLastName(customer.getLastName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setCreditId(customer.getCredit().getId());
        if (customer.getOrders() != null) {
            customerDTO.setOrderDTOS(
                    customer.getOrders().stream()
                            .map(OrderDTO::fromOrder)
                            .collect(Collectors.toSet())
            );
        }

        if (customer.getReviews() != null) {
            customerDTO.setReviewDTOS(
                    customer.getReviews().stream()
                            .map(ReviewDTO::fromReview)
                            .collect(Collectors.toSet())
            );
        }
        return customerDTO;
    }
}
