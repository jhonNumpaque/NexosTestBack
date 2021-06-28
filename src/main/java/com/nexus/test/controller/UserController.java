package com.nexus.test.controller;

import com.nexus.test.models.User;
import com.nexus.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User userDetails) {
        User user = new User();
        user.setAdmissionDate(userDetails.getAdmissionDate());
        user.setAge(userDetails.getAge());
        user.setRole(userDetails.getRole());
        user.setNames(userDetails.getNames());
        return userRepository.save(user);
    }
}
