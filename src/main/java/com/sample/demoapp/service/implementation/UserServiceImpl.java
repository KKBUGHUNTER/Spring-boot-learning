package com.sample.demoapp.service.implementation;

//import com.sample.demoapp.Dto.UserDTO;
//import com.sample.demoapp.mapper.UserMapper;
import com.sample.demoapp.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.demoapp.repository.UserRepository;
import com.sample.demoapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // DTO Code
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public UserDTO findByEmail(String email) {
//        return userMapper.toDto(userRepository.findByEmail(email));
//    }

    // Normal Code
    @Override
    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean addNewUser(UserModel userModel) {
        userRepository.save(userModel);
        return true;
    }

    @Override
    public boolean deleteByEmail(String email) {
        userRepository.deleteByEmail(email);
        return true;
    }

    public boolean updatePassword(String email, String newPassword) {
        UserModel user = userRepository.findByEmail(email);
        if (user != null) {
            user.setPassword(newPassword);
            userRepository.save(user);
            return true;
        }
        return false;
    }

}
