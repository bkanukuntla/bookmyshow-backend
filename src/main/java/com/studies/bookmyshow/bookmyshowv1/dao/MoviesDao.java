package com.studies.bookmyshow.bookmyshowv1.dao;

import com.studies.bookmyshow.bookmyshowv1.entity.MoviesEntity;
import com.studies.bookmyshow.bookmyshowv1.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MoviesDao {

    private final MoviesRepository moviesRepository;

    public MoviesEntity saveMovie(MoviesEntity moviesEntity){
       return moviesRepository.save(moviesEntity);
    }

    public List<MoviesEntity> getAllMovies(){
         return moviesRepository.findAll();
    }

    public MoviesEntity getMovieById(int movieId){
        return moviesRepository.findByMovieId(movieId);
    }

    public void deleteByMovieId(int movieId){
         moviesRepository.deleteByMovieId(movieId);
    }

}
