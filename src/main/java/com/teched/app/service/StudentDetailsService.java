package com.teched.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teched.app.model.TrainerDetails;
import com.teched.app.model.StudentDetails;
import com.teched.app.model.Mapping;
import com.teched.app.repository.TrainerDetailsRepository;
import com.teched.app.repository.StudentDetailsRepository;
import com.teched.app.repository.MappingRepository;


@Service
public class StudentDetailsService {

    @Autowired
    private StudentDetailsRepository repo;

    public StudentDetails save(StudentDetails student) {
        return repo.save(student);
    }

    public List<StudentDetails> getAllStudents() {
        return repo.findAll();
    }

    public Optional<StudentDetails> getByStudentId(Long studentId) {
        return repo.findByStudentId(studentId);
    }

    public void deleteByStudentId(Long studentId) {
        repo.deleteByStudentId(studentId);
    }
}
