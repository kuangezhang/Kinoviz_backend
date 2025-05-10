package com.example.demo.service;

import com.example.demo.model.Movement;
import com.example.demo.repository.MovementRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovementService {

    private final MovementRepository movementRepository;

    public MovementService(MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    public List<Movement> getAllMovements() {
        return movementRepository.findAll();
    }

    public List<Movement> getMovementsByBodyPart(String bodyPart) {
        return movementRepository.findByBodyPartsContainingIgnoreCase(bodyPart);
    }

    public Movement saveMovement(Movement movement) {
        return movementRepository.save(movement);
    }
}
