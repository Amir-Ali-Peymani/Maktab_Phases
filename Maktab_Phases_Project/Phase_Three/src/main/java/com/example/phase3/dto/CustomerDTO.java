package com.example.phase3.dto;

import com.example.phase3.entity.Customer;
import com.example.phase3.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
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
    private String password;
    private long creditId;
    private Set<OrderDTO> orderDTOS;
    private Set<ReviewDTO> reviewDTOS;
    private List<PaymentDTO> paymentDTOS;

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
        if (customer.getPayments() != null) {
            customerDTO.setPaymentDTOS(
                    customer.getPayments().stream()
                            .map(PaymentDTO::fromPayment)
                            .collect(Collectors.toList())
            );
        }
        return customerDTO;
    }

    public static void toCustomer(CustomerDTO customerDTO, Customer oldCustomer){
        oldCustomer.setId(customerDTO.getId());
        oldCustomer.setFirstName(customerDTO.getName());
        oldCustomer.setLastName(customerDTO.getLastName());
        oldCustomer.setPassword(customerDTO.getPassword());
        oldCustomer.setEmail(customerDTO.getEmail());

    }
}
