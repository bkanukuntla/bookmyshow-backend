package com.studies.bookmyshow.bookmyshowv1.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ShowsRequestDto {
    private int showId;
    private int movieId;
    private int screenId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String language;
    private String showType;
}
