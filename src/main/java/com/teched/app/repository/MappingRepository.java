package com.teched.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.teched.app.model.Mapping;
import java.util.List;

@Repository
public interface MappingRepository extends MongoRepository<Mapping, String> {
    List<Mapping> findByTrainerId(int trainerId);
}
