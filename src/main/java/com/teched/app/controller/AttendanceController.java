package com.teched.app.controller;

import com.teched.app.model.Attendance;
import com.teched.app.repository.AttendanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceRepository repo;

    // ✅ Check-in
    @PostMapping("/checkin")
    public Attendance checkIn(@RequestBody Attendance req) {
        Attendance attendance = new Attendance(
                req.getUserId(),
                req.getRole(),
                LocalDateTime.now(),
                req.getLocation()
        );
        return repo.save(attendance);
    }

    // ✅ Check-out
    @PostMapping("/checkout/{id}")
    public Attendance checkOut(@PathVariable String id) {
        Optional<Attendance> opt = repo.findById(id);
        if (opt.isPresent()) {
            Attendance att = opt.get();
            att.setCheckOutTime(LocalDateTime.now());
            return repo.save(att);
        }
        return null;
    }

    // ✅ Get user attendance history
    @GetMapping("/{userId}")
    public List<Attendance> getAttendanceByUser(@PathVariable String userId) {
        return repo.findByUserId(userId);
    }

    // ✅ Get all
    @GetMapping
    public List<Attendance> getAll() {
        return repo.findAll();
    }
}
