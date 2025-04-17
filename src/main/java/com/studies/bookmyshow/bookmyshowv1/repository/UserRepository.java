package com.studies.bookmyshow.bookmyshowv1.repository;

import com.studies.bookmyshow.bookmyshowv1.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {

    Optional<UserEntity> findByEmail(String email);
}
