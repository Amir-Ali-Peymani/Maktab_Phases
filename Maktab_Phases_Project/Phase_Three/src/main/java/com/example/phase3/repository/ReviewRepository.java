package com.example.phase3.repository;

import com.example.phase3.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review getReviewById(Long id);
}
