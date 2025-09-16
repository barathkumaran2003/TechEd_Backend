package com.teched.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.teched.app.model.Attendance;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    List<Attendance> findByUserId(String userId);
}
