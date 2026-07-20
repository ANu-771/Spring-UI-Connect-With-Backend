package com.example.spring_security_test.service;

import com.example.spring_security_test.dto.UserDTO;

public interface UserService {


    UserDTO getUserDetails(String username, String password);

    void saveUser(UserDTO userDTO);

}
