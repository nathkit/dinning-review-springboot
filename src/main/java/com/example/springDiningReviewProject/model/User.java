package com.example.springDiningReviewProject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long Id;

    private String displayName;

    private String city;
    private String state;
    private String zipCode;

    private Boolean peanutWatch;
    private Boolean dairyWatch;
    private Boolean eggWatch;
}
