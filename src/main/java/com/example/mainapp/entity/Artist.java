package com.example.mainapp.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private int yearsOfExperience;
    private String education;
    @OneToMany
    private List<Review> review;
    @OneToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "artist_vacancies",
    joinColumns = @JoinColumn(name = "artist_id"),
    inverseJoinColumns = @JoinColumn(name = "vacancy_id"))
    private List<Vacancy> vacancies;

}
