package com.studies.bookmyshow.bookmyshowv1.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingResponseDto {
    private int bookingId;
    private String userId;
    private int showId;
    private LocalDateTime bookingTime = LocalDateTime.now();
    private String status;
    private BigDecimal price;
}
