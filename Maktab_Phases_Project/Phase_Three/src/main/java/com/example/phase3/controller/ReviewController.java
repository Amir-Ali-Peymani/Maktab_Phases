package com.example.phase3.controller;

import com.example.phase3.entity.Review;
import com.example.phase3.exception.AuthenticationNotFoundException;
import com.example.phase3.exception.BaseHttpException;
import com.example.phase3.exception.NullPointerException;
import com.example.phase3.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping("/saveReview")
    public void saveReview(@RequestBody Review review) throws NullPointerException {
        reviewService.saveReview(review);
    }

    @GetMapping("/getReview/{id}")
    public ResponseEntity<?> getReview(@PathVariable("id")long id){
        try {
            Review review = reviewService.getReviewById(id);
            return ResponseEntity.ok(review);
        }catch (BaseHttpException e){
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @GetMapping("/getAllReview")
    public ResponseEntity<?> getAllReview(){
        try{
            List<Review> reviews = reviewService.getAllReviews();
            return ResponseEntity.ok(reviews);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/updateReview/{id}")
    public void updateReview(@PathVariable("id")long id, @RequestBody Review review) throws NullPointerException {
        reviewService.updateReview(id, review);
    }

    @DeleteMapping("/deleteReview/{id}")
    public void deleteReview(@PathVariable("id")long id) throws AuthenticationNotFoundException {
        reviewService.deleteReview(id);
    }

}
