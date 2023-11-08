package com.example.phase3.service.Impl;

import com.example.phase3.entity.Review;
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
        reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(Long id) throws AuthenticationNotFoundException {
        Review review = reviewRepository.getReviewById(id);
        if (review == null){
            throw new AuthenticationNotFoundException();
        }
        return review;
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
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
