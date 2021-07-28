package com.ashok.practice.rest.webservices.domain;


import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("ignorepwdfilter")
public class Login {

    private String username;
    private String contact;
    private String password;

    public Login(String username, String password, String contact) {
        this.username = username;
        this.contact = contact;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
