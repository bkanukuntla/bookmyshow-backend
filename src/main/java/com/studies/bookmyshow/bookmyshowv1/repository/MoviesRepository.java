package com.studies.bookmyshow.bookmyshowv1.repository;

import com.studies.bookmyshow.bookmyshowv1.entity.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviesRepository extends JpaRepository<MoviesEntity, Integer> {

    public MoviesEntity findByMovieId(int movieId);

    public void deleteByMovieId(int movieId);
}
