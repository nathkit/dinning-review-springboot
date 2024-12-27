package com.example.springDiningReviewProject.repository;

import com.example.springDiningReviewProject.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Optional<Restaurant> findRestaurantsByNameAndZipCode(String name, String zipCode);
    List<Restaurant> findRestaurantsByZipCodeAndPeanutScoreNotNullOrderByPeanutScore(String zipCode);
    List<Restaurant> findRestaurantsByZipCodeAndDairyScoreNotNullOrderByDairyScore(String zipCode);
    List<Restaurant> findRestaurantsByZipCodeAndEggScoreNotNullOrderByEggScore(String zipCode);
}
