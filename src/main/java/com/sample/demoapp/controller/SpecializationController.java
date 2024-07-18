package com.sample.demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sample.demoapp.dto.SpecializationDTO;
import com.sample.demoapp.service.SpecializationService;

import java.util.List;

@RestController
@RequestMapping("/api/specializations")
public class SpecializationController {

    @Autowired
    private SpecializationService specializationService;

    @PostMapping
    public ResponseEntity<SpecializationDTO> createSpecialization(@RequestBody SpecializationDTO specializationDTO) {
        SpecializationDTO createdSpecialization = specializationService.createSpecialization(specializationDTO);
        return ResponseEntity.ok(createdSpecialization);
    }

    @GetMapping
    public ResponseEntity<List<SpecializationDTO>> getAllSpecializations() {
        List<SpecializationDTO> specializations = specializationService.getAllSpecializations();
        return ResponseEntity.ok(specializations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpecializationDTO> getSpecializationById(@PathVariable Integer id) {
        SpecializationDTO specialization = specializationService.getSpecializationById(id);
        return ResponseEntity.ok(specialization);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<SpecializationDTO> getSpecializationByName(@PathVariable String name) {
        SpecializationDTO specialization = specializationService.getSpecializationByName(name);
        return ResponseEntity.ok(specialization);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecializationDTO> updateSpecialization(@PathVariable Integer id,
            @RequestBody SpecializationDTO specializationDTO) {
        SpecializationDTO updatedSpecialization = specializationService.updateSpecialization(id, specializationDTO);
        return ResponseEntity.ok(updatedSpecialization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialization(@PathVariable Integer id) {
        specializationService.deleteSpecialization(id);
        return ResponseEntity.noContent().build();
    }
}
