package com.studies.bookmyshow.bookmyshowv1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieResponseDto {
    private int movieId;

    private String title;

    private String description;

    private int duration;

    private LocalDate releaseDate;

    private String language;

    private String certificate;


}
