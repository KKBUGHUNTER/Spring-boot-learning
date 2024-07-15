package com.sample.demoapp.service;

//import com.sample.demoapp.Dto.UserDTO;
import com.sample.demoapp.model.UserModel;

public interface UserService {

    // DTO Code
//    UserDTO findByEmail(String email);

    // Normal Code
    UserModel findByEmail(String email);
    boolean addNewUser(UserModel userModel);
    boolean deleteByEmail(String email);
    boolean updatePassword(String email, String password);
}
