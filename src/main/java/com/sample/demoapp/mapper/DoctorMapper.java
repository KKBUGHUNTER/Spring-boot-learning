package com.sample.demoapp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.demoapp.dto.DoctorDTO;
import com.sample.demoapp.model.Doctor;

@Component
public class DoctorMapper {

    @Autowired
    private ModelMapper modelMapper;

    public DoctorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DoctorDTO toDTO(Doctor doctor){
        DoctorDTO doctorDTO = modelMapper.map(doctor, DoctorDTO.class);
        if (doctor.getSpecialization() != null) {
            doctorDTO.setSpecializationId(doctor.getSpecialization().getId());
            doctorDTO.setSpecializationName(doctor.getSpecialization().getName());
        }
        if (doctor.getClinic() != null) {
            doctorDTO.setClinicId(doctor.getClinic().getId());
            doctorDTO.setClinicName(doctor.getClinic().getName());
        }
        return doctorDTO;
    }

    public Doctor toEntity(DoctorDTO doctorDTO){
        Doctor doctor = modelMapper.map(doctorDTO, Doctor.class);
        // Assume Specialization and Clinic entities are loaded and set separately
        return doctor;
    }
}
