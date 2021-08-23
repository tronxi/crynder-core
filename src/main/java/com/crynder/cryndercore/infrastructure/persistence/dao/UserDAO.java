package com.crynder.cryndercore.infrastructure.persistence.dao;

import com.crynder.cryndercore.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
}
