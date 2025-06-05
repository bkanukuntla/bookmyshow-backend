package com.studies.bookmyshow.bookmyshowv1.repository;

import com.studies.bookmyshow.bookmyshowv1.entity.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer> {

    public TheaterEntity findByTheaterId(int theaterId);
}
