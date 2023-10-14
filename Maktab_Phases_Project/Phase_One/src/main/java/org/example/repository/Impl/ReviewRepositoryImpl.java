package org.example.repository.Impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.base.BaseRepository;
import org.example.entity.Review;
import org.example.repository.ReviewRepository;

import java.security.spec.ECField;
import java.util.List;

public class ReviewRepositoryImpl extends BaseRepository implements ReviewRepository {
    @Override
    public void saveReview(Review review) {
        try {
            em.getTransaction().begin();
            em.persist(review);
            em.getTransaction().commit();
        }catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Review getReview(Long id) {
        try {
            Review review = em.find(Review.class, id);
            if (review == null) {
                throw new EntityNotFoundException("Review not found with id: " + id);
            }
            return review
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Review not found with id: " + id);
        }
    }

    @Override
    public List<Review> getAllReviews() {
        return em.createQuery("SELECT r FROM Review  r", Review.class).getResultList();
    }

    @Override
    public void updateReview(Review review) {
        try {
            em.getTransaction().begin();
            em.merge(review);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteReview(Review review) {
        try {
            em.getTransaction().begin();
            em.remove(em.contains(review) ? review : em.merge(review));
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
}
