package com.sample.demoapp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.demoapp.dto.SpecializationDTO;
import com.sample.demoapp.model.Specialization;

@Component
public class SpecializationMapper {

    @Autowired
    private ModelMapper modelMapper;

    public SpecializationMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public SpecializationDTO toDTO(Specialization specialization){
        return modelMapper.map(specialization, SpecializationDTO.class);
    }

    public Specialization toEntity(SpecializationDTO specializationDTO){
        return modelMapper.map(specializationDTO, Specialization.class);
    }
}
