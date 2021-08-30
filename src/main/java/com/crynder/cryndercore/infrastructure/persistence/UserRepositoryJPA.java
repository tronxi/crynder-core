package com.crynder.cryndercore.infrastructure.persistence;

import com.crynder.cryndercore.domain.models.user.User;
import com.crynder.cryndercore.domain.repositories.UserRepository;
import com.crynder.cryndercore.infrastructure.persistence.dao.UserDAO;
import com.crynder.cryndercore.infrastructure.persistence.entities.UserEntity;
import com.crynder.cryndercore.infrastructure.persistence.mappers.UserMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryJPA implements UserRepository {

    private final UserDAO userDAO;
    private final UserMapper userMapper;

    public UserRepositoryJPA(UserDAO userDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDAO.findByEmail(email)
                .map(userMapper::map);
    }

    @Override
    public Optional<User> findById(String userId) {
        return userDAO.findById(userId)
                .map(userMapper::map);
    }

    @Override
    public void save(User user) {
        UserEntity userEntity = userMapper.map(user);
        userDAO.save(userEntity);
    }
}
