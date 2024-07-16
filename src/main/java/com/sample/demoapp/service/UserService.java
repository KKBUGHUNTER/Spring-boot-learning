package com.sample.demoapp.service;

import com.sample.demoapp.Dto.UserDTO;
import com.sample.demoapp.model.UserModel;

public interface UserService {

    // DTO Code
    UserDTO findByEmailUsingDTO(String email);
    boolean addNewUserUsingDTO(UserDTO userDTO);
    boolean deleteByEmailUsingDTO(String email);
    boolean updatePasswordUsingDTO(String email, String password);

    // Normal Code
    UserModel findByEmail(String email);
    boolean addNewUser(UserModel userModel);
    boolean deleteByEmail(String email);
    boolean updatePassword(String email, String password);
}
