package com.crynder.cryndercore.infrastructure.api.mappers;

import com.crynder.cryndercore.domain.models.user.CreateUser;
import com.crynder.cryndercore.domain.models.user.User;
import com.crynder.cryndercore.infrastructure.api.dto.CreateUserDTO;
import com.crynder.cryndercore.infrastructure.api.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDTOMapper {
    public CreateUser map(CreateUserDTO createUserDTO) {
        return new CreateUser(createUserDTO.email, createUserDTO.name, createUserDTO.surname, createUserDTO.password);
    }

    public UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.id = user.getId();
        userDTO.name = user.getName();
        userDTO.email = user.getEmail();
        userDTO.surname = user.getSurname();
        return userDTO;
    }
}
