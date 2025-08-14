package com.teched.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.teched.app.model.Mapping;
import com.teched.app.service.MappingService;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/mapping")
public class MappingController {
    @Autowired
    private MappingService mappingService;

    @GetMapping
    public List<Mapping> getAllMappings() { return mappingService.getAllMappings(); }

    @GetMapping("/forTrainer/{trainerId}")
    public ResponseEntity<List<Mapping>> getMappingsForTrainer(@PathVariable int trainerId) {
        List<Mapping> mappings = mappingService.getMappingsByTrainerId(trainerId);
        // Always return 200 OK with an empty list if no mappings (important for frontend)
        return ResponseEntity.ok(mappings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mapping> getMappingById(@PathVariable String id) {
        return mappingService.getMappingById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mapping> createMapping(@RequestBody Mapping mapping) {
        if (mapping.getCourse() == null || mapping.getTrainer() == null || mapping.getTrainerId() == null
            || mapping.getStudents() == null || mapping.getStudents().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        if (mapping.getStatus() == null) mapping.setStatus("Active");
        if (mapping.getDate() == null) mapping.setDate(java.time.LocalDate.now().toString());
        Mapping saved = mappingService.saveMapping(mapping);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mapping> updateMapping(@PathVariable String id, @RequestBody Mapping mapping) {
        return mappingService.getMappingById(id).map(existing -> {
            existing.setCourse(mapping.getCourse());
            existing.setTrainer(mapping.getTrainer());
            existing.setTrainerId(mapping.getTrainerId());
            existing.setStudents(mapping.getStudents());
            existing.setDate(mapping.getDate());
            existing.setStatus(mapping.getStatus());
            mappingService.saveMapping(existing);
            return ResponseEntity.ok(existing);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMapping(@PathVariable String id) {
        if (!mappingService.getMappingById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        mappingService.deleteMapping(id);
        return ResponseEntity.noContent().build();
    }
}
