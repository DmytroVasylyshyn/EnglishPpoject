package com.project.multiligual.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    private int blocked_posts;
    private int blocked_user;



    public int getBlocked_posts() {
        return blocked_posts;
    }

    public void setBlocked_posts(int blocked_posts) {
        this.blocked_posts = blocked_posts;
    }

    public int getBlocked_user() {
        return blocked_user;
    }

    public void setBlocked_user(int blocked_user) {
        this.blocked_user = blocked_user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }






}
