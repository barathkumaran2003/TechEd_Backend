package com.teched.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.teched.app.model.CourseDetails;
import com.teched.app.service.CourseDetailsService;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = "*") // Adjust CORS origins as appropriate
public class CourseDetailsController {

    @Autowired
    private CourseDetailsService courseDetailsService;

    // GET all courses
    @GetMapping
    public List<CourseDetails> getCourses() {
        return courseDetailsService.getAllCourses();
    }

    // GET by course id
    @GetMapping("/{id}")
    public ResponseEntity<CourseDetails> getCourseById(@PathVariable String id) {
        return courseDetailsService.getCourseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create or update a course
    @PostMapping
    public CourseDetails saveCourse(@RequestBody CourseDetails course) {
        return courseDetailsService.saveCourse(course);
    }

    // Optionally: DELETE endpoint
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable String id) {
        courseDetailsService.deleteCourseById(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}
