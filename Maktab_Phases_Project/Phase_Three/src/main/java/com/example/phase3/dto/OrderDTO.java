package com.example.phase3.dto;

import com.example.phase3.entity.Order;
import com.example.phase3.enumeration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private double proposedPrice;
    private Date date;
    private double finalPrice;
    private Date compeletionDate;
    private long customerId;
    private long subServiceId;
    private OrderStatus orderStatus;
    private long specialistId;
    private List<ProposalDTO> proposalDTOS;
    private List<ReviewDTO> reviewDTOS;

    public static OrderDTO fromOrder(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setProposedPrice(order.getProposedPrice());
        orderDTO.setDate(order.getDate());
        orderDTO.setCompeletionDate(order.getCompeletionDate());
        orderDTO.setCustomerId(order.getCustomer().getId());
        orderDTO.setSubServiceId(order.getSubService().getId());
        orderDTO.setOrderStatus(order.getOrderStatus());
        if (order.getProposals() != null) {
            orderDTO.setProposalDTOS(
                    order.getProposals().stream()
                            .map(ProposalDTO::fromProposal)
                            .collect(Collectors.toList())
            );
        }
        if (order.getReviews() != null) {
            orderDTO.setReviewDTOS(
                    order.getReviews().stream()
                            .map(ReviewDTO::fromReview)
                            .collect(Collectors.toList())
            );
        }
        return orderDTO;
    }
}
