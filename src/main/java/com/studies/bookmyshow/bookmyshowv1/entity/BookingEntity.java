package com.studies.bookmyshow.bookmyshowv1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "bookings")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingEntity {

    @Id
    @Column(name = "booking_id", columnDefinition = "char(36)")
    private int bookingId;

    @Column(name = "user_id", columnDefinition = "char(36)")
    private String userId = UUID.randomUUID().toString();

    @Column(name = "show_id", columnDefinition = "char(36)")
    private int showId;

    @Column(name = "booking_time")
    private LocalDateTime bookingTime = LocalDateTime.now();

    private String status;

    @Column(name = "total_amount")
    private BigDecimal price;

}
