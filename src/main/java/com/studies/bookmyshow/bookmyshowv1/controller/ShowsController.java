package com.studies.bookmyshow.bookmyshowv1.controller;

import com.studies.bookmyshow.bookmyshowv1.dto.ShowsRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.ShowsResponseDto;
import com.studies.bookmyshow.bookmyshowv1.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("shows")
public class ShowsController {

    @Autowired
    private ShowsService showsService;

    @PostMapping("/createShow")
    public ShowsResponseDto createShow(@RequestBody ShowsRequestDto showsRequestDto){
        return showsService.createShow(showsRequestDto);
    }

    @GetMapping("/getAllShows")
    public List<ShowsResponseDto> getAllShows(){
        return showsService.getAllShows();
    }

    @GetMapping("/showsById/{id}")
    public ShowsResponseDto getShowsById(@PathVariable("id") int showId){
        return showsService.getShowsById(showId);
    }

}
