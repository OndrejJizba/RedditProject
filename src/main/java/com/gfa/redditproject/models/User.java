package com.gfa.redditproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String username;
    private String password;
    private String retypePassword;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
