package com.student.Voting;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Vote")
public class User {
    private String id;
    private String username;
    private String password;
}
