package com.project.multiligual.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.util.Date;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long postid;
    private String title;
    private String fulltext;
    private String anons;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getPostid() {
        return postid;
    }

    public void setPostid(long postid) {
        this.postid = postid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFulltext() {
        return fulltext;
    }

    public void setFulltext(String fulltext) {
        this.fulltext = fulltext;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }
}
