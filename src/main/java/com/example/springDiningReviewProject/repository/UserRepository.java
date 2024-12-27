package com.example.springDiningReviewProject.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.springDiningReviewProject.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByDisplayName(String displayName);
}
