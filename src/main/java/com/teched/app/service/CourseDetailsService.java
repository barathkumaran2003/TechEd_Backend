package com.teched.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teched.app.model.CourseDetails;
import com.teched.app.repository.CourseDetailsRepository;

@Service
public class CourseDetailsService {

    @Autowired
    private CourseDetailsRepository courseDetailsRepository;

    public CourseDetails saveCourse(CourseDetails course) {
        return courseDetailsRepository.save(course);
    }

    public List<CourseDetails> getAllCourses() {
        return courseDetailsRepository.findAll();
    }

    public Optional<CourseDetails> getCourseById(String id) {
        return courseDetailsRepository.findById(id);
    }

    public void deleteCourseById(String id) {
        courseDetailsRepository.deleteById(id);
    }
}
