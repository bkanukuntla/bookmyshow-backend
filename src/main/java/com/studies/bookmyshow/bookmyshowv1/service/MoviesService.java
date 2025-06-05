package com.studies.bookmyshow.bookmyshowv1.service;

import com.studies.bookmyshow.bookmyshowv1.dao.MoviesDao;
import com.studies.bookmyshow.bookmyshowv1.dto.MovieRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.MovieResponseDto;
import com.studies.bookmyshow.bookmyshowv1.entity.MoviesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoviesService {

    @Autowired
    private MoviesDao moviesDao;

    public MovieResponseDto saveMovie(MovieRequestDto movieRequestDto){
        MoviesEntity movie = convertDtoToEntity(movieRequestDto);
        moviesDao.saveMovie(movie);
        return convertEntityToDto(movie);
    }

    public List<MovieResponseDto> getAllMovies(){
        List<MoviesEntity> allMovies =  moviesDao.getAllMovies();
        return convertEntityListToDtoList(allMovies);
    }

    public MovieResponseDto getMovieById(int movieId){
       MoviesEntity movieById =  moviesDao.getMovieById(movieId);
       return convertEntityToDto(movieById);
    }
    @Transactional
    public MovieResponseDto deleteMovieById(int movieId){
        MoviesEntity movie = moviesDao.getMovieById(movieId);
       moviesDao.deleteByMovieId(movieId);
       return convertEntityToDto(movie);
    }

    public MovieResponseDto updateMovieById(int movieId, MovieRequestDto movieRequestDto){
        MoviesEntity movie = moviesDao.getMovieById(movieId);

        movie.setTitle(movieRequestDto.getTitle());
        movie.setDescription(movieRequestDto.getDescription());
        movie.setLanguage(movieRequestDto.getLanguage());
        movie.setDuration(movieRequestDto.getDuration());
        movie.setCertificate(movieRequestDto.getCertificate());
        movie.setReleaseDate(movieRequestDto.getReleaseDate());

        MoviesEntity updatedMovie = moviesDao.saveMovie(movie);

        return convertEntityToDto(updatedMovie);


    }


    private List<MovieResponseDto> convertEntityListToDtoList(List<MoviesEntity> moviesEntities){
        List<MovieResponseDto> movieResponseDtos = new ArrayList<>();

        for(MoviesEntity movies : moviesEntities){
            MovieResponseDto movieResponseDto = new MovieResponseDto();
            movieResponseDto.setMovieId(movies.getMovieId());
            movieResponseDto.setTitle(movies.getTitle());
            movieResponseDto.setCertificate(movies.getCertificate());
            movieResponseDto.setLanguage(movies.getLanguage());
            movieResponseDto.setDuration(movies.getDuration());
            movieResponseDto.setDescription(movies.getDescription());
            movieResponseDto.setReleaseDate(movies.getReleaseDate());
            movieResponseDtos.add(movieResponseDto);
        }
        return movieResponseDtos;
    }

    private MoviesEntity convertDtoToEntity(MovieRequestDto movieRequestDto){
        return MoviesEntity.builder()
                .movieId(movieRequestDto.getMovieId())
                .title(movieRequestDto.getTitle())
                .description(movieRequestDto.getDescription())
                .duration(movieRequestDto.getDuration())
                .releaseDate(movieRequestDto.getReleaseDate())
                .language(movieRequestDto.getLanguage())
                .certificate(movieRequestDto.getCertificate())
                .build();
    }

    private MovieResponseDto convertEntityToDto(MoviesEntity moviesEntity){
        return MovieResponseDto.builder()
                .movieId(moviesEntity.getMovieId())
                .title(moviesEntity.getTitle())
                .releaseDate(moviesEntity.getReleaseDate())
                .language(moviesEntity.getLanguage())
                .duration(moviesEntity.getDuration())
                .description(moviesEntity.getDescription())
                .certificate(moviesEntity.getCertificate())
                .build();
    }
}
