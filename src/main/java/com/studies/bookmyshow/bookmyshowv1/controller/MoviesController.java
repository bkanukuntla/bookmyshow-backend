package com.studies.bookmyshow.bookmyshowv1.controller;

import com.studies.bookmyshow.bookmyshowv1.dto.MovieRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.MovieResponseDto;
import com.studies.bookmyshow.bookmyshowv1.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @PostMapping("/saveMovie")
    public MovieResponseDto saveMovie(@RequestBody MovieRequestDto movieRequestDto){
        return moviesService.saveMovie(movieRequestDto);
    }

    @GetMapping("/getMovies")
    public List<MovieResponseDto> getAllMovies(){
        return moviesService.getAllMovies();
    }

    @GetMapping("/movies/{id}")
    public MovieResponseDto getMovieById(@PathVariable("id") int movieId){
        return moviesService.getMovieById(movieId);
    }

    @DeleteMapping("/movies/{id}")
    public MovieResponseDto deleteMovieById(@PathVariable("id") int movieId){
        return moviesService.deleteMovieById(movieId);
    }

    @PutMapping("/movies/{id}")
    public MovieResponseDto updateMovieById(@PathVariable ("id") int movieId, MovieRequestDto movieRequestDto){
        return moviesService.updateMovieById(movieId, movieRequestDto);
    }

}
