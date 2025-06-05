package com.studies.bookmyshow.bookmyshowv1.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class MovieRequestDto {
    private int movieId;

    private String title;

    private String description;

    private int duration;

    private LocalDate releaseDate;

    private String language;

    private String certificate;
}
