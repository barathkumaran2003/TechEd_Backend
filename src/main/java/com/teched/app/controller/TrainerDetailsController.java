package com.teched.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.teched.app.model.TrainerDetails;
import com.teched.app.service.TrainerDetailsService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/trainer")
public class TrainerDetailsController {
    @Autowired
    private TrainerDetailsService trainerService;

    @GetMapping
    public List<TrainerDetails> getAllTrainers() {
        return trainerService.getAllTrainers();
    }

    @GetMapping("/{trainerId}")
    public ResponseEntity<TrainerDetails> getTrainerById(@PathVariable int trainerId) {
        return trainerService.getTrainerById(trainerId)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TrainerDetails> registerTrainer(@RequestBody TrainerDetails trainer) {
        if (trainer == null || trainer.getFullName() == null) return ResponseEntity.badRequest().build();
        if (trainer.getDate() == null) trainer.setDate(java.time.LocalDate.now().toString());
        if (trainer.getStatus() == null) trainer.setStatus("Pending");
        TrainerDetails saved = trainerService.saveTrainer(trainer);
        return ResponseEntity.ok(saved);
    }
}
