package com.student.Voting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VoteService {
    @Autowired
    private VoteRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public String login(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid Username or password";
        }
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
