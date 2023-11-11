package com.example.phase3.dto;

import com.example.phase3.entity.Review;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private long id;
    private int rating;
    private String comment;
    private long customerId;
    private long orderId;

    public static ReviewDTO fromReview(Review review) {
        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setId(review.getId());
        reviewDTO.setRating(review.getRating());
        reviewDTO.setComment(review.getComment());
        reviewDTO.setCustomerId(review.getCustomer().getId());
        reviewDTO.setOrderId(review.getOrder().getId());
        return reviewDTO;
    }
}
