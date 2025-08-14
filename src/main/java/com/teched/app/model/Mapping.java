package com.teched.app.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mappings")
public class Mapping {
    @Id
    private String id;
    private String course;
    private String trainer;
    private Integer trainerId;
    private List<String> students;
    private String date;
    private String status;

    @DBRef private TrainerDetails trainerDetails;
    @DBRef private CourseDetails courseDetails;

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getCourse() { return course; }
    public void setCourse(String course) { this.course = course; }
    public String getTrainer() { return trainer; }
    public void setTrainer(String trainer) { this.trainer = trainer; }
    public Integer getTrainerId() { return trainerId; }
    public void setTrainerId(Integer trainerId) { this.trainerId = trainerId; }
    public List<String> getStudents() { return students; }
    public void setStudents(List<String> students) { this.students = students; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public TrainerDetails getTrainerDetails() { return trainerDetails; }
    public void setTrainerDetails(TrainerDetails trainerDetails) { this.trainerDetails = trainerDetails; }
    public CourseDetails getCourseDetails() { return courseDetails; }
    public void setCourseDetails(CourseDetails courseDetails) { this.courseDetails = courseDetails; }
}
