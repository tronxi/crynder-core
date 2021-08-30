package com.crynder.cryndercore.configuration.security.services;

import com.crynder.cryndercore.domain.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserDetailSecurityService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailSecurityService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        com.crynder.cryndercore.domain.models.user.User user = userService.findByEmail(email);
        return userBuilder(user.getEmail(), user.getPassword());
    }

    private User userBuilder(String email, String password) {
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        List<GrantedAuthority> authorities = Collections.emptyList();
        return new User(email, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}