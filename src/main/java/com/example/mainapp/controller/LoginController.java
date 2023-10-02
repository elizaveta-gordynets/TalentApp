package com.example.mainapp.controller;

import com.example.mainapp.dto.UserDto;
import com.example.mainapp.service.UserDetailsServiceImpl;
import com.example.mainapp.util.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@RestController
@RequestMapping("/auth")
public class LoginController {

    private final JwtUtils jwtUtils;
   // private final UserDetailsServiceImpl service;
    private final AuthenticationManager authenticationManager;
/*
    private final BCryptPasswordEncoder encoder;
*/

    public LoginController(JwtUtils jwtUtils,
                           UserDetailsServiceImpl service,
                           AuthenticationManager authenticationManager,
                           BCryptPasswordEncoder encoder) {
        this.jwtUtils = jwtUtils;

        this.authenticationManager = authenticationManager;

    }

    @PostMapping(value = "/signIn")
    public ResponseEntity<UserDto> authenticateUser(@RequestBody UserDto userDto) {
        try {
           /* UserDetailsImpl details = service.loadUserByUsername(userDto.getUsername());
            if(encoder.matches(userDto.getPassword(), details.getPassword())) {
                Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                        details.getUsername(), userDto.getPassword()));*/
            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),
                    userDto.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(auth);

                return ResponseEntity.ok()
                        .header(AUTHORIZATION, jwtUtils.generateToken(auth))
                        .body(userDto);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(UNAUTHORIZED).build();
        }
    }
}
