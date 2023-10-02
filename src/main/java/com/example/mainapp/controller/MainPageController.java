package com.example.mainapp.controller;

import com.example.mainapp.dto.UserDto;
import com.example.mainapp.entity.User;
import com.example.mainapp.service.UserService;
import com.example.mainapp.service.VacancyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {

    private final VacancyService service;
    private final UserService userService;

    public MainPageController(VacancyService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping("/auth/signIn")
    public String getLoginPage() {
        return "authPage";
    }

    @GetMapping("/hello")
    public String getIndexPage(Model model) {
        model.addAttribute("name", "Lissss");
        return "index";
    }

    @GetMapping(value = "/vacancies")
    public String getAllVacancies(ModelMap model) {
        model.addAttribute("vacancies", service.findAllVacancies());
        return "mainPage";
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

}
