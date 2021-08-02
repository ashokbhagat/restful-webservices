package com.ashok.practice.rest.webservices.controller;

import com.ashok.practice.rest.webservices.dao.UserDAOService;
import com.ashok.practice.rest.webservices.domain.User;
import com.ashok.practice.rest.webservices.exceptions.UserNotFoundException;
import com.ashok.practice.rest.webservices.exceptions.UserNotSupportedException;
import com.ashok.practice.rest.webservices.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaController {

    @Autowired
    private UserDAOService userDAO;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public User getUser(@PathVariable int id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent())
            throw new UserNotFoundException(id + " user is not found");
        return user.get();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userDAO.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteById(@PathVariable int id) throws UserNotSupportedException {
        User user = userDAO.deleteById(id);

        if (user == null) {
            throw new UserNotSupportedException("id : " + id + " is not found, can not delete");
        }
    }

}
