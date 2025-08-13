package com.VotingApp.project.service;

import java.util.List;

import com.VotingApp.project.repository.UserRepository;
import com.VotingApp.project.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostConstruct
    public void init() {
        // Create an admin user
        if (userRepository.findByUsername("admin") == null) {
            User adminUser = new User();
            adminUser.setUsername("admin");
            adminUser.setPassword("admin@12");
            adminUser.setEmailId("Admin123@gmail.com");
            adminUser.setPhoneNo("9372355141");
            adminUser.setAdmin(true);
            adminUser.setHasVoted(null);
            userRepository.save(adminUser);
        }
    }
}
