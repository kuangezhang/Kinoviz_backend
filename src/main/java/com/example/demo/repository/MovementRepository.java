package com.example.demo.repository;

import com.example.demo.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, Long> {

    // Custom method to find movements by body part (case-insensitive)
    List<Movement> findByBodyPartsContainingIgnoreCase(String bodyPart);
}
