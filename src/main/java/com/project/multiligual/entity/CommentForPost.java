package com.project.multiligual.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CommentForPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comment_id;

    private String fulltext;

    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "postid")
    private Posts posts;

    public CommentForPost() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

//    public CommentForPost(String fulltext, Posts posts, User user) {
//        this.fulltext = fulltext;
//        this.posts = posts;
//        this.user=user;
//        this.date= LocalDate.now();
//    }
    public CommentForPost(String fulltext, Posts posts) {
        this.fulltext = fulltext;
        this.posts = posts;
        this.date= LocalDate.now();
    }




}
