package com.example.mainapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ArtistDto {

    private String firstName;
    private String lastName;
    private int yearsOfExperience;
    private String education;
    List<ReviewDto> reviews;
    List<VacancyDto> vacancies;
}
