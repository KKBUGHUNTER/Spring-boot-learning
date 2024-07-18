package com.sample.demoapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.demoapp.dto.SpecializationDTO;
import com.sample.demoapp.mapper.SpecializationMapper;
import com.sample.demoapp.model.Specialization;
import com.sample.demoapp.repository.SpecializationRepository;
import com.sample.demoapp.service.SpecializationService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private SpecializationMapper specializationMapper;

    @Override
    public SpecializationDTO createSpecialization(SpecializationDTO specializationDTO) {
        Specialization specialization = specializationMapper.toEntity(specializationDTO);
        Specialization savedSpecialization = specializationRepository.save(specialization);
        return specializationMapper.toDTO(savedSpecialization);
    }

    @Override
    public List<SpecializationDTO> getAllSpecializations() {
        return specializationRepository.findAll()
                .stream()
                .map(specializationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SpecializationDTO getSpecializationById(Integer id) {
        Specialization specialization = specializationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found"));
        return specializationMapper.toDTO(specialization);
    }

    @Override
    public SpecializationDTO updateSpecialization(Integer id, SpecializationDTO specializationDTO) {
        Specialization existingSpecialization = specializationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found"));
        existingSpecialization.setName(specializationDTO.getName());
        existingSpecialization.setRating(specializationDTO.getRating());
        Specialization updatedSpecialization = specializationRepository.save(existingSpecialization);
        return specializationMapper.toDTO(updatedSpecialization);
    }

    @Override
    public void deleteSpecialization(Integer id) {
        Specialization specialization = specializationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found"));
        specializationRepository.delete(specialization);
    }

    @Override
    public SpecializationDTO getSpecializationByName(String name) {
        Specialization specialization = specializationRepository.findByName(name)
                .orElseThrow(() -> new RuntimeException("Specialization not found"));
        return specializationMapper.toDTO(specialization);
    }
    
}
