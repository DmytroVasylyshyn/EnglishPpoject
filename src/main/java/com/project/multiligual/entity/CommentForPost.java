package com.project.multiligual.entity;

import jakarta.persistence.*;

import java.awt.*;
import java.util.Date;

@Entity
public class CommentForPost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long comment_id;

    private String fulltext;

    private Date date;
    @ManyToOne
    @JoinColumn(name = "postid")
    private Posts posts;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }
}
