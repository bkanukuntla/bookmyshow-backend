package com.studies.bookmyshow.bookmyshowv1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShowsResponseDto {
    private int showId;
    private int movieId;
    private int screenId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String language;
    private String showType;
}
