package com.sample.demoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sample.demoapp.dto.ClinicDTO;
import com.sample.demoapp.service.ClinicService;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @PostMapping
    public ResponseEntity<ClinicDTO> createClinic(@RequestBody ClinicDTO clinicDTO) {
        ClinicDTO createdClinic = clinicService.createClinic(clinicDTO);
        return ResponseEntity.ok(createdClinic);
    }

    @GetMapping
    public ResponseEntity<List<ClinicDTO>> getAllClinics() {
        List<ClinicDTO> clinics = clinicService.getAllClinics();
        return ResponseEntity.ok(clinics);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClinicDTO> getClinicById(@PathVariable Long id) {
        ClinicDTO clinic = clinicService.getClinicById(id);
        return ResponseEntity.ok(clinic);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ClinicDTO> getClinicByName(@PathVariable String name) {
        ClinicDTO clinic = clinicService.getClinicByName(name);
        return ResponseEntity.ok(clinic);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClinicDTO> updateClinic(@PathVariable Long id, @RequestBody ClinicDTO clinicDTO) {
        ClinicDTO updatedClinic = clinicService.updateClinic(id, clinicDTO);
        return ResponseEntity.ok(updatedClinic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClinic(@PathVariable Long id) {
        clinicService.deleteClinic(id);
        return ResponseEntity.noContent().build();
    }
}
