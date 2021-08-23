package com.crynder.cryndercore.domain.repositories;

import com.crynder.cryndercore.domain.models.user.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    void save(User user);
}
