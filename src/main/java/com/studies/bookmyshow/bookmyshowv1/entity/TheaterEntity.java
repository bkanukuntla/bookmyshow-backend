package com.studies.bookmyshow.bookmyshowv1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "theaters")
public class TheaterEntity {

    @Id
    @Column(name = "theater_id", columnDefinition = "CHAR(36)")
    private int theaterId;

    @Column(name = "theater_name")
    private String theaterName;

    private String location;

    private String city;

}
