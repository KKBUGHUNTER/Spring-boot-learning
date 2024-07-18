package com.sample.demoapp.service;

import com.sample.demoapp.dto.SpecializationDTO;
import java.util.List;

public interface SpecializationService {
    SpecializationDTO createSpecialization(SpecializationDTO specializationDTO);
    List<SpecializationDTO> getAllSpecializations();
    SpecializationDTO getSpecializationById(Integer id);
    SpecializationDTO updateSpecialization(Integer id, SpecializationDTO specializationDTO);
    void deleteSpecialization(Integer id);
    SpecializationDTO getSpecializationByName(String name);
}
