package com.example.mainapp.repository;

import com.example.mainapp.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepo extends JpaRepository<Vacancy, Long> {


}
