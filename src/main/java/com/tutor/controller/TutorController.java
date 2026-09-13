package com.tutor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tutor.dto.TutorDTO;
import com.tutor.service.TutorService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "/tutor")
public class TutorController {

    @Autowired
    private TutorService service;

    // Add Tutor
    @PostMapping("/addTutor")
    public TutorDTO addTutor(@ModelAttribute TutorDTO dto) {
        return service.addTutor(dto);
    }

    // Update Tutor
    @PutMapping("/UpdateTutor/{tutor_id}")
    public TutorDTO updateTutor(
            @PathVariable long tutor_id,
            @ModelAttribute TutorDTO dto) {

        return service.updateTutor(tutor_id, dto);
    }

    // Delete Tutor
    @DeleteMapping("/DeleteTutor/{tutor_id}")
    public String deleteTutor(@PathVariable long tutor_id) {
        return service.deleteTutor(tutor_id);
    }

    // Get Tutor by ID
    @GetMapping("/ViewTutor/{tutor_id}")
    public TutorDTO getTutor(@PathVariable long tutor_id) {
        return service.getTutor(tutor_id);
    }

    // Search by Name
    @GetMapping("/ViewByName/{name}")
    public List<TutorDTO> findByName(@PathVariable String name) {
        return service.findByName(name);
    }

    // Search by Phone
    @GetMapping("/ViewByPhone/{phonenumber}")
    public TutorDTO findByPhonenumber(@PathVariable long phonenumber) {
        return service.findByPhonenumber(phonenumber);
    }

    // Search by Email
    @GetMapping("/ViewByEmail/{email}")
    public TutorDTO findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    // Search by City
    @GetMapping("/ViewByCity/{city}")
    public List<TutorDTO> findByCity(@PathVariable String city) {
        return service.findByCity(city);
    }

    // Search by Course
    @GetMapping("/ViewByCourse/{course}")
    public List<TutorDTO> findByCourse(@PathVariable String course) {
        return service.findByCourse(course);
    }

    // Get All Tutors
    @GetMapping({"/", "/AllTutor"})
    public List<TutorDTO> getAllTutors() {
        return service.getAllTutors();
    }
}