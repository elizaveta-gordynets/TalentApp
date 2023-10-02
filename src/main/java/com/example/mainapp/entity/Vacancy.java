package com.example.mainapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "vacancies")
public class Vacancy {

    @Id
    private Long id;
    private String vacancyTitle;
    private String description;
    private LocalDate datePosted;
    private LocalDate dateUpdated;
    @ManyToMany(mappedBy = "vacancies")
    private List<Artist> appliedArtists;

}
