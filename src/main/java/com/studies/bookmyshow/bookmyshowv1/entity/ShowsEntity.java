package com.studies.bookmyshow.bookmyshowv1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shows")
@Data
public class ShowsEntity {

    @Id
    @Column(name = "show_id", columnDefinition = "char(36)")
    private int showId;

    @Column(name = "movie_id", columnDefinition = "char(36)")
    private int movieId;

    @Column(name = "screen_id", columnDefinition = "char(36)")
    private int screenId;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    private String language;

    @Column(name = "show_type")
    private String showType;
}
