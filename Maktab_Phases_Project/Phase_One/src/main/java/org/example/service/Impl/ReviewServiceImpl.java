package org.example.service.Impl;

import org.example.base.BaseRepository;
import org.example.entity.Review;
import org.example.repository.ReviewRepository;
import org.example.service.ReviewService;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void saveReview(Review review) {
        reviewRepository.saveReview(review);
    }

    @Override
    public Review getReview(Long id) {
        return reviewRepository.getReview(id);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepository.getAllReviews();
    }

    @Override
    public void updateReview(Review review) {
        reviewRepository.updateReview(review);
    }

    @Override
    public void deleteReview(Review review) {
        reviewRepository.deleteReview(review);
    }
}
