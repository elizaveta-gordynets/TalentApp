package com.example.mainapp.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDto {

    private String message;
    private String title;
    private int mark;
}
