package com.example.spring_security_test.service;

import com.example.spring_security_test.dto.UserDTO;

import java.util.List;

public interface UserService {


    UserDTO getUserDetails(String username, String password);

    void saveUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();
}
