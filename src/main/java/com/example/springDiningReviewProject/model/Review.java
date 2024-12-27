package com.example.springDiningReviewProject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Review {
    
    @Id
    @GeneratedValue
    private Long id;

    private String  submittedBy;
    private Long restaurantId;
    private String review;

    private Integer peanutScore;
    private Integer eggScore;
    private Integer dairyScore;

    private ReviewStatus status;
}
