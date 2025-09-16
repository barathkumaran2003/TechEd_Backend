package com.teched.app.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Attendance")
public class Attendance {

    @Id
    private String id;

    private String userId;      // email or studentId
    private String role;        // trainer/student
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private String location;
    private LocalDateTime date; // for day-level reporting

    public Attendance() {}

    public Attendance(String userId, String role, LocalDateTime checkInTime, String location) {
        this.userId = userId;
        this.role = role;
        this.checkInTime = checkInTime;
        this.location = location;
        this.date = checkInTime;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public LocalDateTime getCheckInTime() { return checkInTime; }
    public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; }

    public LocalDateTime getCheckOutTime() { return checkOutTime; }
    public void setCheckOutTime(LocalDateTime checkOutTime) { this.checkOutTime = checkOutTime; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
}
