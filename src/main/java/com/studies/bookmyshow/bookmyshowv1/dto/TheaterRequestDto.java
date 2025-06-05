package com.studies.bookmyshow.bookmyshowv1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TheaterRequestDto {

    private int theaterId;

    private String theaterName;

    private String location;

    private String city;
}
