package com.example.mainapp.service;

import com.example.mainapp.dto.ArtistDto;
import com.example.mainapp.dto.ReviewDto;
import com.example.mainapp.dto.VacancyDto;
import com.example.mainapp.entity.Review;
import com.example.mainapp.repository.ArtistRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArtistService {

    private final ArtistRepo artistRepo;

    public ArtistService(ArtistRepo artistRepo) {
        this.artistRepo = artistRepo;
    }


    /**
     * To-do: add filters, pagination, dynamic sorting
     *
     */
    public List<ArtistDto> findAllArtists() {
        return artistRepo.findAll().stream().map(entity -> ArtistDto.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .education(entity.getEducation())
                .reviews(entity.getReview().stream().map(rev -> ReviewDto.builder()
                                .message(rev.getMessage())
                                .title(rev.getTitle())
                                .mark(rev.getMark())
                                .build())
                        .collect(Collectors.toList()))
                .vacancies(entity.getVacancies().stream().map(vac -> VacancyDto.builder()
                        .header(vac.getVacancyTitle())
                        .description(vac.getDescription())
                        .datePosted(vac.getDatePosted())
                        .dateUpdated(vac.getDateUpdated())
                        .build()
                ).collect(Collectors.toList()))
                .build()).collect(Collectors.toList());
    }

}
