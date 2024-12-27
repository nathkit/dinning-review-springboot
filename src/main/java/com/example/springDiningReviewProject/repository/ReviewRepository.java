package com.example.springDiningReviewProject.repository;

import com.example.springDiningReviewProject.model.Review;
import com.example.springDiningReviewProject.model.ReviewStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    List<Review> findReviewsByRestaurantIdAndStatus(Long restaurantId, ReviewStatus reviewStatus);
    List<Review> findReviewsByStatus(ReviewStatus reviewStatus);
}
