package com.example.mainapp.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "years_of_experience")
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
