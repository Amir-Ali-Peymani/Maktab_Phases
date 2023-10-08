package org.example.service;

import org.example.entity.Review;

import java.util.List;

public interface ReviewService {

    void saveReview(Review review);

    Review getReview(Long id);

    List<Review> getAllReviews();

    void updateReview(Review review);

    void deleteReview(Review review);
}
