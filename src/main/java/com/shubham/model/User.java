package com.shubham.model;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid", updatable = false, nullable = false)
    private Integer userid;

    @Column(name = "first_name",nullable = false)
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "dob")
    private String dob;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "email_id",nullable = false)
    private String email_id;


    public User() {
        super();
    }

    public User(Integer userid,String first_name,String last_name,String username,String password,String dob,String email_id) {

        this.userid=userid;
        this.first_name=first_name;
        this.last_name=last_name;
        this.username=username;
        this.password=password;
        this.dob=dob;
        this.email_id=email_id;

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
}
