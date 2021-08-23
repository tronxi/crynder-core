package com.crynder.cryndercore.domain.services;

import com.crynder.cryndercore.domain.exceptions.UserAlreadyExistException;
import com.crynder.cryndercore.domain.models.user.CreateUser;
import com.crynder.cryndercore.domain.models.user.User;
import com.crynder.cryndercore.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(CreateUser createUser) {
        userRepository.findByEmail(createUser.getEmail())
                .ifPresent(user -> {throw new UserAlreadyExistException("user with email " + user.getEmail() + " already exist");});
        User user = generateUser(createUser);
        userRepository.save(user);
        return user;
    }

    private User generateUser(CreateUser createUser) {
        String id = UUID.randomUUID().toString();
        return new User(id, createUser.getEmail(), createUser.getName(), createUser.getSurname(), createUser.getPassword());
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
