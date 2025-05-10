package com.example.demo.controller;

import com.example.demo.model.Movement;
import com.example.demo.repository.MovementRepository;
import com.example.demo.service.MovementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movements")
public class MovementController {

    private final MovementRepository movementRepository;
    private final MovementService movementService;


    @Autowired
    public MovementController(MovementRepository movementRepository, MovementService movementService) {
        this.movementRepository = movementRepository;
        this.movementService = movementService;
    }

    // Create a new movement
    @PostMapping
    public ResponseEntity<Movement> create(@RequestBody Movement movement) {
        Movement saved = movementRepository.save(movement);
        return ResponseEntity.ok(saved);
    }



    @GetMapping
    public ResponseEntity<List<Movement>> getByBodyPart(@RequestParam(required = false) String bodyPart) {
        List<Movement> result = (bodyPart == null)
                ? movementService.getAllMovements()
                : movementService.getMovementsByBodyPart(bodyPart);

        return ResponseEntity.ok(result);
    }

}
