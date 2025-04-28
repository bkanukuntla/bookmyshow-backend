package com.studies.bookmyshow.bookmyshowv1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MoviesEntity {

    @Id
    @Column(name = "movie_id", columnDefinition = "CHAR(36)")
    private int movieId;

    private String title;

    private String description;

    private int duration;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private String language;

    private String certificate;

}
