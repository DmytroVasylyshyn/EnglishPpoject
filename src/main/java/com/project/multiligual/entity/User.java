package com.project.multiligual.entity;

import jakarta.persistence.*;

import java.util.Optional;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String username;
    private String usersurname;
    private String password;
    private String email;
    private String phonenumber;
    private int age;
    private String title;
    private int languageid;
    private String qualification;
    private String about_mae;


    @Lob
    private byte[] icon;

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public User(String about_mae) {
        this.about_mae = about_mae;
    }


    public String getAbout_mae() {
        return about_mae;
    }

    public void setAbout_mae(String about_mae) {
        this.about_mae = about_mae;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User() {
    }

    public User(String username, String email, String title, String about_mae, byte[] icon) {
        this.username = username;
        this.email = email;
        this.title = title;
        this.about_mae = about_mae;
        this.icon = icon;
    }

    public User(String username, String email, String password, String qualification) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.qualification=qualification;
    }

    public User(String usersurname, String phonenumber, int age, int languageid, String qualification) {
        this.usersurname = usersurname;
        this.phonenumber = phonenumber;
        this.age = age;
        this.languageid = languageid;
        this.qualification = qualification;
    }



    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsersurname() {
        return usersurname;
    }

    public void setUsersurname(String usersurname) {
        this.usersurname = usersurname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLanguageid() {
        return languageid;
    }

    public void setLanguageid(int languageid) {
        this.languageid = languageid;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
