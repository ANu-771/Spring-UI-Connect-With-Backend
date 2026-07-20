package com.example.spring_security_test.controller;

import com.example.spring_security_test.dto.AuthDTO;
import com.example.spring_security_test.dto.CommonResponse;
import com.example.spring_security_test.dto.UserDTO;
import com.example.spring_security_test.dto.UserDataDTO;
import com.example.spring_security_test.repository.UserRepository;
import com.example.spring_security_test.security.JwtUtil;
import com.example.spring_security_test.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/test")
@CrossOrigin
@RequiredArgsConstructor
public class TestController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @GetMapping(value = "/testing")
    public String testSecurity(){
        return "API Security Successful";
    }

    @PostMapping(value = "/login",produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResponse authLogin(@RequestBody AuthDTO authDTO){
        UserDTO userDetails = userService.getUserDetails(authDTO.getUserName(), authDTO.getPassword());
        System.out.println("API called here");
        String token = jwtUtil.generateToken(userDetails);

        UserDataDTO userDataDTO = new UserDataDTO();
        userDataDTO.setUserId(userDetails.getUserId());
        userDataDTO.setToken(token);
        return new CommonResponse(0,userDataDTO,"JWT Token");
    }




}
