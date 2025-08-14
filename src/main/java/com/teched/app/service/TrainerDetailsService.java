package com.teched.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teched.app.model.TrainerDetails;
import com.teched.app.repository.TrainerDetailsRepository;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerDetailsService {
    @Autowired
    private TrainerDetailsRepository repo;

    public List<TrainerDetails> getAllTrainers() { return repo.findAll(); }

    public Optional<TrainerDetails> getTrainerById(int trainerId) {
        return repo.findByTrainerId(trainerId);
    }

    public int getNextTrainerId() {
        TrainerDetails lastTrainer = repo.findTopByOrderByTrainerIdDesc();
        if (lastTrainer == null || lastTrainer.getTrainerId() == null) return 5000;
        return lastTrainer.getTrainerId() + 1;
    }

    public TrainerDetails saveTrainer(TrainerDetails trainer) {
        if (trainer.getTrainerId() == null) {
            int nextId = getNextTrainerId();
            trainer.setTrainerId(nextId);
        }
        return repo.save(trainer);
    }
}
