package Phase_Two.service;

import Phase_Two.entity.Review;

import java.util.List;

public interface ReviewService {

    void saveReview(Review review);

    Review getReviewById(Long id);

    List<Review> getAllReviews();

    void updateReview(Review review);

    void deleteReview(Review review);
}
