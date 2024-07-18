package com.sample.demoapp.service;

import com.sample.demoapp.dto.ClinicDTO;
import java.util.List;

public interface ClinicService {
    ClinicDTO createClinic(ClinicDTO clinicDTO);
    List<ClinicDTO> getAllClinics();
    ClinicDTO getClinicById(Long id);
    ClinicDTO getClinicByName(String name);
    ClinicDTO updateClinic(Long id, ClinicDTO clinicDTO);
    void deleteClinic(Long id);
}
