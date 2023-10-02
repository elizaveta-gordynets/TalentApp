package com.example.mainapp.controller;

import com.example.mainapp.dto.ArtistDto;
import com.example.mainapp.service.ArtistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("/artists")
    public ResponseEntity<List<ArtistDto>> findAllArtists(){
        return ResponseEntity.ok(artistService.findAllArtists());
    }
}
