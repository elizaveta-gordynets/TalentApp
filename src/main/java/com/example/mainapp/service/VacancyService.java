package com.example.mainapp.service;

import com.example.mainapp.dto.VacancyDto;
import com.example.mainapp.entity.Vacancy;
import com.example.mainapp.repository.VacancyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacancyService {

    private final VacancyRepo vacancyRepo;

    public VacancyService(VacancyRepo vacancyRepo) {
        this.vacancyRepo = vacancyRepo;
    }

    /**
     * To-do: add filters, pagination, dynamic sorting
     *
     */
    public List<VacancyDto> findAllVacancies(){
        return vacancyRepo.findAll().stream().map(vac -> VacancyDto.builder()
                .header(vac.getVacancyTitle())
                .description(vac.getDescription())
                .datePosted(vac.getDatePosted())
                .dateUpdated(vac.getDateUpdated())
                .build()).collect(Collectors.toList());
    }
}
