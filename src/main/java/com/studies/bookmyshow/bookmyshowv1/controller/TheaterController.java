package com.studies.bookmyshow.bookmyshowv1.controller;

import com.studies.bookmyshow.bookmyshowv1.dto.TheaterRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.TheaterResponseDto;
import com.studies.bookmyshow.bookmyshowv1.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/saveTheater")
    public TheaterResponseDto saveTheater(@RequestBody TheaterRequestDto theaterRequestDto){
        return theaterService.saveTheater(theaterRequestDto);
    }

    @GetMapping("/getTheaters")
    public List<TheaterResponseDto> getAllTheaters(){
        return theaterService.getAllTheaters();
    }

    @GetMapping("/theater/{id}")
    public TheaterResponseDto getTheaterById(@PathVariable ("id") int theaterId){
        return theaterService.getTheaterById(theaterId);

    }



}
