package com.studies.bookmyshow.bookmyshowv1.repository;

import com.studies.bookmyshow.bookmyshowv1.entity.ShowsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowsRepository extends JpaRepository<ShowsEntity, Integer> {

    //public List<ShowsEntity> findAllShows();

    public ShowsEntity findByShowId(int showId);
}
