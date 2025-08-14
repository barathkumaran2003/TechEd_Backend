package com.teched.app.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teched.app.model.TrainerDetails;
import com.teched.app.model.StudentDetails;
import com.teched.app.model.Mapping;

@Repository
public interface StudentDetailsRepository extends MongoRepository<StudentDetails, String> {
    Optional<StudentDetails> findByStudentId(Long studentId);
    void deleteByStudentId(Long studentId);
}
