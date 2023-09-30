package com.example.mainapp.service;

import com.example.mainapp.dto.UserDto;
import com.example.mainapp.entity.Role;
import com.example.mainapp.entity.User;
import com.example.mainapp.repository.RoleRepo;
import com.example.mainapp.repository.UserRepo;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final BCryptPasswordEncoder encoder;

    public UserService(UserRepo userRepo,
                       BCryptPasswordEncoder encoder,
                       RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.roleRepo = roleRepo;
    }

    @Transactional
    public void saveUser(UserDto userDto) {
        User user = new User();
        Role role = roleRepo.findByRole("ROLE_USER");
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setRoles(Set.of(role));
        userRepo.save(user);
    }



}
