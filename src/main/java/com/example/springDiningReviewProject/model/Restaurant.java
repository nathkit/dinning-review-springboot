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
public class Restaurant {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String line1;
    private String city;
    private String state;
    private String zipCode;

    private String phoneNumber;
    private String website;

    private String overallScore;
    private String peanutScore;
    private String dairyScore;
    private String eggScore;


    // Replace by @RequiredArgsConstructor

    // public Restaurant() {

    // }

    // public Restaurant(Restaurannt restaurant) {
    //     this.name = restaurant.getName();
    //     this.line1 = restaurant.getLine1();
    //     this.city = restaurant.getCity();
    //     this.state = restaurant.getState();
    //     this.zipCode = restaurant.getZipCode();
    //     this.phoneNumber = restaurant.getPhoneNumber();
    //     this.website = restaurant.getWebsite();
    //     this.overallScore = restaurant.getOverAllScore();
    //     this.peanutScore = restaurant.getPeanutScore();
    //     this.dairyScore = restaurant.getDairyScore();
    //     this.eggScore = restaurant.getEggScore();
    // }


}