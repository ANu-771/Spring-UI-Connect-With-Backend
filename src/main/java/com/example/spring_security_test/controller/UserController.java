package com.example.spring_security_test.controller;

import com.example.spring_security_test.dto.CommonResponse;
import com.example.spring_security_test.dto.UserDTO;
import com.example.spring_security_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/user")
@CrossOrigin
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse saveUser(@RequestBody UserDTO userDTO){
        userService.saveUser(userDTO);
        return new CommonResponse(0, "Success", "User saved successfully");
    }


    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse getAllUsers() { //
        List<UserDTO> allUsers = userService.getAllUsers(); //
        return new CommonResponse(0, allUsers, "Get All users API"); //
    }


}
