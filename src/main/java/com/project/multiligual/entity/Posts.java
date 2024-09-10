package com.project.multiligual.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long postid;
    private String title;
    private String fulltext;
    private String anons;
    private Date date;
    private int likes;
    private String link;
    private String Global_Tags;
    private String Secondary_Tags;

    @Lob
    private byte[] photo;

    @JoinColumn
    @Column(name = "user_id")
    private long userId; // замість об'єкта користувача, використовуємо просто ідентифікатор користувача

    public Posts(String title, String fulltext, long userId) {
        this.title = title;
        this.fulltext = fulltext;
        this.anons = (fulltext.length() > 200) ? fulltext.substring(0, 200) : fulltext;
        this.userId = userId;
    }
    public Posts() {

    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getGlobal_Tags() {
        return Global_Tags;
    }

    public void setGlobal_Tags(String global_Tags) {
        Global_Tags = global_Tags;
    }

    public String getSecondary_Tags() {
        return Secondary_Tags;
    }

    public void setSecondary_Tags(String secondary_Tags) {
        Secondary_Tags = secondary_Tags;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }


}
