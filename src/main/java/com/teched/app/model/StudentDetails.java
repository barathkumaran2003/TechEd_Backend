package com.teched.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "StudentDetails")
public class StudentDetails {

    @Id
    private String id;

    private long studentId; // Numeric student ID

    private String name;
    private String course;
    private String combo;

    private String trainer;

    private List<Fee> fees;  // Per-course fee info

    private String couponOrReferral;
    private String paymentDate;
    private String contact;
    private String email;
    private String profilePicUrl;
    private String paymentMode;

    // Fee nested class (embedded document)
    public static class Fee {
        private String course;
        private double amount;
        private String status; // "Paid" or "Pending"

        public Fee() { }

        public Fee(String course, double amount, String status) {
            this.course = course;
            this.amount = amount;
            this.status = status;
        }

        public String getCourse() { return course; }

        public void setCourse(String course) { this.course = course; }

        public double getAmount() { return amount; }

        public void setAmount(double amount) { this.amount = amount; }

        public String getStatus() { return status; }

        public void setStatus(String status) { this.status = status; }
    }

    // Getters and setters

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public long getStudentId() { return studentId; }

    public void setStudentId(long studentId) { this.studentId = studentId; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCourse() { return course; }

    public void setCourse(String course) { this.course = course; }

    public String getCombo() { return combo; }

    public void setCombo(String combo) { this.combo = combo; }

    public String getTrainer() { return trainer; }

    public void setTrainer(String trainer) { this.trainer = trainer; }

    public List<Fee> getFees() { return fees; }

    public void setFees(List<Fee> fees) { this.fees = fees; }

    public String getCouponOrReferral() { return couponOrReferral; }

    public void setCouponOrReferral(String couponOrReferral) { this.couponOrReferral = couponOrReferral; }

    public String getPaymentDate() { return paymentDate; }

    public void setPaymentDate(String paymentDate) { this.paymentDate = paymentDate; }

    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getProfilePicUrl() { return profilePicUrl; }

    public void setProfilePicUrl(String profilePicUrl) { this.profilePicUrl = profilePicUrl; }

    public String getPaymentMode() { return paymentMode; }

    public void setPaymentMode(String paymentMode) { this.paymentMode = paymentMode; }
}
