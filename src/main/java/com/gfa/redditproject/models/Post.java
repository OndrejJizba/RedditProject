package com.gfa.redditproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private int votes;
    private String title;
    private String URL;
    @CreationTimestamp
    private LocalDate date;

    public Post(String title, String URL) {
        this.title = title;
        this.URL = URL;
        this.votes = 0;
        this.date = getDate();
    }
}
