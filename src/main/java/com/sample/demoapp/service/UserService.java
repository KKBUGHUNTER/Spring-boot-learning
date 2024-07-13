package com.sample.demoapp.service;

import com.sample.demoapp.model.UserModel;

public interface UserService {
    
    UserModel findByEmail(String email);
    
}
