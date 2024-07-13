package com.sample.demoapp.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demoapp.model.UserModel;
import com.sample.demoapp.repository.UserRepository;
import com.sample.demoapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    // Field injection
    @Autowired
    UserRepository userRepository;


    // Implementation findByEmail function in UserService class.
    @Override
    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
