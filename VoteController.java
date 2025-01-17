package com.student.Voting;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;;

@RestController
@RequestMapping("/vote")

public class VoteController {
    @Autowired
    private VoteService userService;

    @PostMapping("/hello")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/hii")
    public String login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping
    public List<User> getAllUser() {
        return userService.getAll();
    }
}
