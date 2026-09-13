package com.tutor.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutor.model.Tutor;

public interface TutorRepository extends JpaRepository<Tutor, Long> {

    List<Tutor> findByName(String name);

    Optional<Tutor> findByPhonenumber(long phonenumber);

    Optional<Tutor> findByEmail(String email);

    List<Tutor> findByCity(String city);

    List<Tutor> findByCourse(String course);
}
