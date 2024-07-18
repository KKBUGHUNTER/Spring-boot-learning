package com.sample.demoapp.service;

import com.sample.demoapp.dto.DoctorDTO;
import java.util.List;

public interface DoctorService {
    DoctorDTO createDoctor(DoctorDTO doctorDTO);
    List<DoctorDTO> getAllDoctors();
    DoctorDTO getDoctorById(Integer id);
    DoctorDTO updateDoctor(Integer id, DoctorDTO doctorDTO);
    void deleteDoctor(Integer id);
}
