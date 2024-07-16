package com.sample.demoapp.mapper;

import com.sample.demoapp.Dto.UserDTO;
import com.sample.demoapp.model.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO toDto(UserModel userModel) {
        return modelMapper.map(userModel, UserDTO.class);
    }

    public UserModel toEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserModel.class);
    }
}
