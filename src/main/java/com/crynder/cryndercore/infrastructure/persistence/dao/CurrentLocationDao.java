package com.crynder.cryndercore.infrastructure.persistence.dao;

import com.crynder.cryndercore.infrastructure.persistence.entities.CurrentLocationEntity;
import com.crynder.cryndercore.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrentLocationDao extends JpaRepository<CurrentLocationEntity, Long> {
    Optional<CurrentLocationEntity> findByUser(UserEntity userEntity);
}
