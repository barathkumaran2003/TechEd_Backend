package com.teched.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teched.app.model.Mapping;
import com.teched.app.repository.MappingRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MappingService {
    @Autowired
    private MappingRepository mappingRepository;

    public List<Mapping> getAllMappings() { return mappingRepository.findAll(); }
    public Optional<Mapping> getMappingById(String id) { return mappingRepository.findById(id); }
    public List<Mapping> getMappingsByTrainerId(int trainerId) { return mappingRepository.findByTrainerId(trainerId); }
    public Mapping saveMapping(Mapping mapping) { return mappingRepository.save(mapping); }
    public void deleteMapping(String id) { mappingRepository.deleteById(id); }
}
