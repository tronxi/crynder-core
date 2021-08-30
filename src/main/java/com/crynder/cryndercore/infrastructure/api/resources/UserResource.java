package com.crynder.cryndercore.infrastructure.api.resources;

import com.crynder.cryndercore.configuration.security.services.JwtService;
import com.crynder.cryndercore.domain.models.user.User;
import com.crynder.cryndercore.domain.services.UserService;
import com.crynder.cryndercore.domain.usecases.CreateUserUseCase;
import com.crynder.cryndercore.infrastructure.api.dto.CreateUserDTO;
import com.crynder.cryndercore.infrastructure.api.dto.UserDTO;
import com.crynder.cryndercore.infrastructure.api.mappers.UserDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("users")
public class UserResource {

    private final CreateUserUseCase createUserUseCase;
    private final UserService userService;
    private final JwtService jwtService;
    private final UserDTOMapper userDTOMapper;

    @Autowired
    public UserResource(CreateUserUseCase createUserUseCase,
                        UserService userService,
                        JwtService jwtService,
                        UserDTOMapper userDTOMapper) {
        this.createUserUseCase = createUserUseCase;
        this.userService = userService;
        this.jwtService = jwtService;
        this.userDTOMapper = userDTOMapper;
    }

    @PostMapping
    public ResponseEntity<UserDTO> register(@RequestBody CreateUserDTO createUserDTO) {
        User user = createUserUseCase.create(userDTOMapper.map(createUserDTO));
        return ResponseEntity.ok(userDTOMapper.map(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@AuthenticationPrincipal org.springframework.security.core.userdetails.User activeUser) {
        User user = userService.findByEmail(activeUser.getUsername());
        return ResponseEntity.ok(jwtService.createToken(user.getEmail(), user.getId()));
    }
}
