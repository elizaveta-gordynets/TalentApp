package com.example.mainapp.repository;

import com.example.mainapp.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArtistRepo extends JpaRepository<Artist, Long> {

    List<Artist> findAll();

    Optional<Artist> findById(Long id);

    @Modifying
    @Query(value = "UPDATE artists SET years_of_experience= :numOfYears WHERE id = :id", nativeQuery = true)
    void updateArtistsExperience(@Param("numOfYears") int numberOfYears,
                                 @Param("id") Long id);


}
