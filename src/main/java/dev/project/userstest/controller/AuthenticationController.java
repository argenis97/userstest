package dev.project.userstest.controller;

import dev.project.userstest.dto.response.AuthResponseDTO;
import dev.project.userstest.security.JWTUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authManager;
    private final JWTUtil jwtUtil;

    public AuthenticationController(AuthenticationManager authManager, JWTUtil jwtUtil) {
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDTO> authenticate(@RequestBody AuthDTO request) {
        Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName()
                , request.getPassword()));

        UserDetails user = (UserDetails) auth.getPrincipal();

        String token = jwtUtil.generateToken(user);

        return new ResponseEntity<>(new AuthResponseDTO(user.getUsername(), token), HttpStatus.OK);
    }
}
