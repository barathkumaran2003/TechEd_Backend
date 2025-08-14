package com.teched.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.teched.app.model.CourseDetails;

public interface CourseDetailsRepository extends MongoRepository<CourseDetails, String> {
    // Additional query methods (if needed) go here
}
