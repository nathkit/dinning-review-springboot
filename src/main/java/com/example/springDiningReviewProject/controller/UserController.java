package com.example.springDiningReviewProject.controller;

import com.example.springDiningReviewProject.model.User;
import com.example.springDiningReviewProject.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{displayName}")
    public User getUser(@PathVariable String displayName) {
        validateDisplayName(displayName);

        Optional<User> optionalExistingUser = userRepository.findUserByDisplayName(displayName);
        if (!optionalExistingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        User existingUser = optionalExistingUser.get();
        existingUser.setId(null);
        
        return existingUser;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody User user) {
        validateUser(user);

        userRepository.save(user);
    }

    @PutMapping("/{displayNamne}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserProfile(@PathVariable String displayName, @RequestBody User updateUser){
        validateDisplayName("displayName");

        Optional<User> optionalExistingUser = userRepository.findUserByDisplayName(displayName);
        if (optionalExistingUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        User existingUser = optionalExistingUser.get();

        copyUserInfoForm(updateUser, existingUser);
        userRepository.save(existingUser);
        
    }

    private void copyUserInfoForm(User updateUser, User existingUser) {
        if (ObjectUtils.isEmpty(updateUser.getDisplayName())) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        if (!ObjectUtils.isEmpty(updateUser.getCity())) {
            existingUser.setCity(updateUser.getCity());
        }

        if (!ObjectUtils.isEmpty(updateUser.getState())) {
            existingUser.setState(updateUser.getState());
        }

        if (!ObjectUtils.isEmpty(updateUser.getZipCode())) {
            existingUser.setZipCode(updateUser.getZipCode());
        }

        if (!ObjectUtils.isEmpty(updateUser.getPeanutWatch())) {
            existingUser.setPeanutWatch(updateUser.getPeanutWatch());
        }

        if (!ObjectUtils.isEmpty(updateUser.getDairyWatch())) {
            existingUser.setDairyWatch(updateUser.getDairyWatch());
        }

        if (!ObjectUtils.isEmpty(updateUser.getEggWatch())) {
            existingUser.setEggWatch(updateUser.getEggWatch());
        }
    }

    private void validateUser(User user) {
        validateDisplayName(user.getDisplayName());

        Optional<User> existingUser = userRepository.findUserByDisplayName(user.getDisplayName());
        if (existingUser.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    private void validateDisplayName(String displayName) {
        if (ObjectUtils.isEmpty(displayName)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
