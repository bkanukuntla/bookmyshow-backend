package com.studies.bookmyshow.bookmyshowv1.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data

public class BookingRequestDto {
    private int bookingId;
    private String userId;
    private int showId;
    private LocalDateTime bookingTime = LocalDateTime.now();
    private String status;
    private BigDecimal price;
}
