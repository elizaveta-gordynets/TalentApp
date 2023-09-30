package com.example.mainapp.controller;

import com.example.mainapp.dto.UserDto;
import com.example.mainapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/auth")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegistrationPge() {
        return "registration";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("userInfo") UserDto dto,
                               Model model) {
        userService.saveUser(dto);
        model.addAttribute("username", dto.getUsername());
        model.addAttribute("email", dto.getEmail());
        return "userPage";
    }
}
