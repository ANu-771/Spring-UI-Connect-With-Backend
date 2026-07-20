package com.example.spring_security_test.service.impl;

import com.example.spring_security_test.dto.UserDTO;
import com.example.spring_security_test.entity.User;
import com.example.spring_security_test.repository.UserRepository;
import com.example.spring_security_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDTO getUserDetails(String username, String password) {

        Optional<User> optionalUser = userRepository.findByUserNameAndPassword(username,password);
        if(optionalUser.isEmpty())
            throw new RuntimeException("Sorry no user");

        User user = optionalUser.get();
        return new UserDTO(user.getUserId(),user.getUserName(),user.getUserRoles(),user.getPassword());

    }

    @Override
   public void saveUser(UserDTO userDTO) {
        User user = new User();
        user.setUserName(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setUserRoles(userDTO.getUserRoles());
        userRepository.save(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> allUsers = userRepository.getAllUsers();
        return allUsers;
    }
}
