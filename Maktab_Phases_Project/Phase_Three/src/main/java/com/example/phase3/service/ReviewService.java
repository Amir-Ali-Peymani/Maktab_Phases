package com.example.phase3.service;

import com.example.phase3.entity.Review;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.NullPointerException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    void saveReview(Review review) throws NullPointerException;

    Review getReviewById(Long id) throws AuthenticationNotFoundException;

    List<Review> getAllReviews();

    void updateReview(Long id, Review review) throws NullPointerException;

    void deleteReview(Long id) throws AuthenticationNotFoundException;
}
