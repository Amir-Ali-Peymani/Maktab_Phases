package com.example.phase3.service.Impl;

import com.example.phase3.dto.ReviewDTO;
import com.example.phase3.entity.Review;
import com.example.phase3.enumeration.OrderStatus;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.repository.ReviewRepository;
import com.example.phase3.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public void saveReview(Review review) throws NullPointerException {
        if (review == null || review.getCustomer() == null || review.getOrder() == null){
            throw new NullPointerException();
        }
        if (review.getOrder().getOrderStatus().equals(OrderStatus.COMPLETED)){
            reviewRepository.save(review);
        }else {

        }

    }

    @Override
    public ReviewDTO getReviewById(Long id) throws AuthenticationNotFoundException {
        Review review = reviewRepository.getReviewById(id);
        if (review == null){
            throw new AuthenticationNotFoundException();
        }
        return ReviewDTO.fromReview(review);
    }

    @Override
    public List<ReviewDTO> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream()
                .map(ReviewDTO::fromReview)
                .toList();
    }

    @Override
    public void updateReview(Long id, Review review) throws NullPointerException {
        Review reviewUpdate = reviewRepository.getReviewById(id);
        if (reviewUpdate == null){
            throw new NullPointerException();
        }
        reviewUpdate.setComment(review.getComment());
        reviewRepository.save(reviewUpdate);
    }

    @Override
    public void deleteReview(Long id) throws AuthenticationNotFoundException {
        Review review = reviewRepository.getReviewById(id);
        if (review == null){
            throw new AuthenticationNotFoundException();
        }
        reviewRepository.delete(review);
    }
}
