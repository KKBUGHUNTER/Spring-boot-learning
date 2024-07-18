package com.sample.demoapp.service;

import com.sample.demoapp.dto.PatientDTO;
import java.util.List;

public interface PatientService {
    PatientDTO createPatient(PatientDTO patientDTO);
    List<PatientDTO> getAllPatients();
    PatientDTO getPatientById(Integer id);
    PatientDTO updatePatient(Integer id, PatientDTO patientDTO);
    void deletePatient(Integer id);
}
