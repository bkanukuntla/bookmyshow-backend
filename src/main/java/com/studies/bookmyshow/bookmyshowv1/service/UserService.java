package com.studies.bookmyshow.bookmyshowv1.service;

import com.studies.bookmyshow.bookmyshowv1.config.AppConfig;
import com.studies.bookmyshow.bookmyshowv1.dao.UserDao;
import com.studies.bookmyshow.bookmyshowv1.dto.LoginRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.LoginResponseDto;
import com.studies.bookmyshow.bookmyshowv1.dto.UserRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.UserResponseDto;
import com.studies.bookmyshow.bookmyshowv1.entity.UserEntity;
import com.studies.bookmyshow.bookmyshowv1.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public UserResponseDto registerUser(UserRequestDto userRequestDto){
        UserEntity user = convertDtoToEntity(userRequestDto);
        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
        userDao.saveUser(user);

        return convertEntityToDto(user);
    }

    private UserEntity convertDtoToEntity(UserRequestDto userRequestDto){
        return UserEntity.builder()
                .name(userRequestDto.getName())
                .email(userRequestDto.getEmail())
                .phoneNumber(userRequestDto.getPhoneNumber())
                .password(passwordEncoder.encode(userRequestDto.getPassword()))
                .build();
    }

    private UserResponseDto convertEntityToDto(UserEntity userEntity){
        return UserResponseDto.builder()
                .userId(userEntity.getUserId())
                .name(userEntity.getName())
                .email(userEntity.getEmail())
                .phoneNumber(userEntity.getPhoneNumber())
                .build();
    }

    public LoginResponseDto loginUser(LoginRequestDto loginRequestDto){
        Optional<UserEntity> optionalUSer = userDao.findByEmail(loginRequestDto.getEmail());

        if(optionalUSer.isEmpty()){
            throw new RuntimeException("User not found");
        }

        UserEntity user = optionalUSer.get();

        boolean passwordMatch = passwordEncoder.matches(loginRequestDto.getPassword(), user.getPassword());

        if(!passwordMatch){
            throw new RuntimeException("Invalid password");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        LoginResponseDto response = new LoginResponseDto();
        response.setEmail(user.getEmail());
        response.setToken(token);
        return response;
    }


}
