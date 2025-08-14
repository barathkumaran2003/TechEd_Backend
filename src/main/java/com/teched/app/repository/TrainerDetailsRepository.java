package com.teched.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import com.teched.app.model.TrainerDetails;

@Repository
public interface TrainerDetailsRepository extends MongoRepository<TrainerDetails, String> {
    TrainerDetails findTopByOrderByTrainerIdDesc();
    Optional<TrainerDetails> findByTrainerId(int trainerId); // Important for GET by numeric
}
