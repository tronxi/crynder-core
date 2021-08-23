package com.crynder.cryndercore.infrastructure.persistence.mappers;

import com.crynder.cryndercore.domain.models.user.User;
import com.crynder.cryndercore.infrastructure.persistence.entities.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User map(UserEntity userEntity) {
        return new User(userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getName(),
                userEntity.getSurname(),
                userEntity.getPassword());
    }

    public UserEntity map(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setEmail(user.getEmail());
        userEntity.setName(user.getName());
        userEntity.setSurname(user.getSurname());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userEntity;
    }
}
