package com.tutor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutor.dto.TutorDTO;
import com.tutor.model.Tutor;
import com.tutor.repository.TutorRepository;

@Service
public class TutorServiceImp implements TutorService {

    @Autowired
    private TutorRepository repo;

    // Add Tutor
    @Override
    public TutorDTO addTutor(TutorDTO dto) {

        Tutor t = mapToEntity(dto);

        Tutor saved = repo.save(t);

        return mapToDTO(saved);
    }

    // Update Tutor
    @Override
    public TutorDTO updateTutor(long tutor_id, TutorDTO dto) {

        Tutor existing = repo.findById(tutor_id)
                .orElseThrow(() -> new RuntimeException("Tutor Not Found"));

        // Don't update tutor_id
        existing.setName(dto.getName());
        existing.setPhonenumber(dto.getPhonenumber());
        existing.setEmail(dto.getEmail());
        existing.setCity(dto.getCity());
        existing.setCourse(dto.getCourse());

        Tutor updated = repo.save(existing);

        return mapToDTO(updated);
    }

    // Delete Tutor
    @Override
    public String deleteTutor(long tutor_id) {

        Tutor existing = repo.findById(tutor_id)
                .orElseThrow(() -> new RuntimeException("Tutor Not Found"));

        repo.delete(existing);

        return "Tutor Deleted Successfully";
    }

    // Get Tutor by ID
    @Override
    public TutorDTO getTutor(long tutor_id) {

        Tutor t = repo.findById(tutor_id)
                .orElseThrow(() -> new RuntimeException("Tutor Not Found"));

        return mapToDTO(t);
    }

    // Search by Name
    @Override
    public List<TutorDTO> findByName(String name) {

        List<Tutor> tutors = repo.findByName(name);

        return tutors.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Search by Phone Number
    @Override
    public TutorDTO findByPhonenumber(long phonenumber) {

        Tutor t = repo.findByPhonenumber(phonenumber)
                .orElseThrow(() -> new RuntimeException("Tutor Not Found"));

        return mapToDTO(t);
    }

    // Search by Email
    @Override
    public TutorDTO findByEmail(String email) {

        Tutor t = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Tutor Not Found"));

        return mapToDTO(t);
    }

    // Search by City
    @Override
    public List<TutorDTO> findByCity(String city) {

        List<Tutor> tutors = repo.findByCity(city);

        return tutors.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Search by Course
    @Override
    public List<TutorDTO> findByCourse(String course) {

        List<Tutor> tutors = repo.findByCourse(course);

        return tutors.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // Get All Tutors
    @Override
    public List<TutorDTO> getAllTutors() {

        List<Tutor> list = repo.findAll();

        return list.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    // DTO -> Entity
    public Tutor mapToEntity(TutorDTO dto) {

        return Tutor.builder()
                .name(dto.getName())
                .phonenumber(dto.getPhonenumber())
                .email(dto.getEmail())
                .city(dto.getCity())
                .course(dto.getCourse())
                .build();
    }

    // Entity -> DTO
    public TutorDTO mapToDTO(Tutor t) {

        TutorDTO dto = new TutorDTO();

        dto.setTutor_id(t.getTutor_id());
        dto.setName(t.getName());
        dto.setPhonenumber(t.getPhonenumber());
        dto.setEmail(t.getEmail());
        dto.setCity(t.getCity());
        dto.setCourse(t.getCourse());

        return dto;
    }
}