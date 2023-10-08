package org.example.repository;

import org.example.entity.Review;

import java.util.List;

public interface ReviewRepository {

    void saveReview(Review review);

    Review getReview(Long id);

    List<Review> getAllReviews();

    void updateReview(Review review);

    void deleteReview(Review review);
}
