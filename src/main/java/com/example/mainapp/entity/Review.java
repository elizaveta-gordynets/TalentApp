package com.example.mainapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @Id
    private Long id;
    private String message;
    private String title;
    private int mark;
    @ManyToOne
    private Artist artist;

}
