package com.project.own.socialapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;

    @JoinColumn(name = "post")
    private StringBuilder post;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User userId;

    @JoinColumn(name = "like_counter")
    private Integer likeCounter;

    public void incrementLikeCounter() {
        likeCounter++;
    }
}
