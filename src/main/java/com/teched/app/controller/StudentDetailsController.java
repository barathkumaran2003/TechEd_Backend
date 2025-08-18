package com.teched.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.teched.app.model.StudentDetails;
import com.teched.app.service.StudentDetailsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "Student API", description = "Operations related to students")
@RestController
@RequestMapping("/api")
public class StudentDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(StudentDetailsController.class);

    @Autowired
    private StudentDetailsService service;

    @Operation(summary = "Register a new student")
    @PostMapping("/student")
    public ResponseEntity<StudentDetails> register(@RequestBody StudentDetails student) {
        if (student == null || student.getName() == null) {
            return ResponseEntity.badRequest().build();
        }
        StudentDetails saved = service.save(student);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/student")
    public List<StudentDetails> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<StudentDetails> getById(@PathVariable Long studentId) {
        Optional<StudentDetails> student = service.getByStudentId(studentId);
        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long studentId) {
        try {
            service.deleteByStudentId(studentId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            logger.error("Error deleting student ID {}: {}", studentId, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/upload-profile")
    public ResponseEntity<String> uploadProfile(@RequestParam("file") MultipartFile file) {
        try {
            String filename = UUID.randomUUID() + "_" + file.getOriginalFilename();
            Path uploadDir = Paths.get(System.getProperty("user.dir"), "uploads");
            if (!Files.exists(uploadDir)) {
                Files.createDirectories(uploadDir);
            }
            Path filepath = uploadDir.resolve(filename);
            Files.write(filepath, file.getBytes());
            String fileUrl = "http://localhost:8060/uploads/" + filename;
            return ResponseEntity.ok(fileUrl);
        } catch (IOException e) {
            logger.error("Upload failed", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload failed");
        }
    }

    @GetMapping("/upload-profile")
    public String checkUpload() {
        return "Upload endpoint working";
    }
}
