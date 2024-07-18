package com.sample.demoapp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.demoapp.dto.PatientDTO;
import com.sample.demoapp.model.Patient;

@Component
public class PatientMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PatientMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public PatientDTO toDTO(Patient patient){
        return modelMapper.map(patient, PatientDTO.class);
    }

    public Patient toEntity(PatientDTO patientDTO){
        return modelMapper.map(patientDTO, Patient.class);
    }
}
