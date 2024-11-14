package dev.project.userstest.service;

import dev.project.userstest.dto.UserDetailsCustom;
import dev.project.userstest.persistence.entity.AppUser;
import dev.project.userstest.persistence.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public CustomUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (!StringUtils.hasText(username))
            return null;

        AppUser user = repository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("No se encontro usuario con nombre "
                        + username));

        return new UserDetailsCustom(user.getName(), user.getPassword(), List.of());
    }
}
