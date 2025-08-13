package com.VotingApp.project.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "candidates")
public class Candidate {
    @Id
    private String id;
    private String name;
    private int voteCount;
}
