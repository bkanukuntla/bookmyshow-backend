package com.studies.bookmyshow.bookmyshowv1.dao;

import com.studies.bookmyshow.bookmyshowv1.entity.UserEntity;
import com.studies.bookmyshow.bookmyshowv1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {

    private final UserRepository userRepository;

    public void saveUser(UserEntity user){
        userRepository.save(user);
    }

    public Optional<UserEntity> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
