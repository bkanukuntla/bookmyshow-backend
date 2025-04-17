package com.studies.bookmyshow.bookmyshowv1.controller;

import com.studies.bookmyshow.bookmyshowv1.dto.LoginRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.LoginResponseDto;
import com.studies.bookmyshow.bookmyshowv1.dto.UserRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.UserResponseDto;
import com.studies.bookmyshow.bookmyshowv1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public UserResponseDto signup(@RequestBody UserRequestDto userRequestDto){
        return userService.registerUser(userRequestDto);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        return userService.loginUser(loginRequestDto);
    }

    @GetMapping("/api/secure/hello")
    public String helloSecure() {
        return "Hello Bhavitha 👋, you're authenticated!";
    }
}
