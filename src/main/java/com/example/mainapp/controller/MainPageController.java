package com.example.mainapp.controller;

import com.example.mainapp.dto.VacancyDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {

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
        List<VacancyDto> vacancyDtos = new ArrayList<>();
        vacancyDtos.add(VacancyDto.builder()
                        .description("Some description")
                        .header("Header for first one")
                .build());
        vacancyDtos.add(VacancyDto.builder()
                        .header("Secod header")
                        .description("Second Description")
                .build());
        model.addAttribute("vacancies", vacancyDtos);
        return "mainPage";
    }
}
