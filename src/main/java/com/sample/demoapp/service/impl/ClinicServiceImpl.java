package com.sample.demoapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.demoapp.dto.ClinicDTO;
import com.sample.demoapp.mapper.ClinicMapper;
import com.sample.demoapp.model.Clinic;
import com.sample.demoapp.repository.ClinicRepository;
import com.sample.demoapp.service.ClinicService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private ClinicMapper clinicMapper;

    @Override
    public ClinicDTO createClinic(ClinicDTO clinicDTO) {
        Clinic clinic = clinicMapper.toEntity(clinicDTO);
        Clinic savedClinic = clinicRepository.save(clinic);
        return clinicMapper.toDTO(savedClinic);
    }

    @Override
    public List<ClinicDTO> getAllClinics() {
        return clinicRepository.findAll()
                .stream()
                .map(clinicMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClinicDTO getClinicById(Long id) {
        Clinic clinic = clinicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));
        return clinicMapper.toDTO(clinic);
    }

    @Override
    public ClinicDTO getClinicByName(String name) {
        Clinic clinic = clinicRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));
        return clinicMapper.toDTO(clinic);
    }

    @Override
    public ClinicDTO updateClinic(Long id, ClinicDTO clinicDTO) {
        Clinic existingClinic = clinicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));
        existingClinic.setName(clinicDTO.getName());
        existingClinic.setAddress(clinicDTO.getAddress());
        Clinic updatedClinic = clinicRepository.save(existingClinic);
        return clinicMapper.toDTO(updatedClinic);
    }

    @Override
    public void deleteClinic(Long id) {
        Clinic clinic = clinicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinic not found"));
        clinicRepository.delete(clinic);
    }
}
