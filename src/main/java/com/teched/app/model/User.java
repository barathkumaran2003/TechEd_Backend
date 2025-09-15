package com.teched.app.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    private String email;
    private String password;
    private String mobileNo;
    private String role; // admin, trainer, student, head

    public User() {}

    public User(String email, String password, String mobileNo, String role) {
        this.email = email;
        this.password = password;
        this.mobileNo = mobileNo;
        this.role = role;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) { this.password = password; }

    public String getMobileNo() {
        return mobileNo;
    }
    public void setMobileNo(String mobileNo) { this.mobileNo = mobileNo; }

    public String getRole() {
        return role;
    }
    public void setRole(String role) { this.role = role; }
}
