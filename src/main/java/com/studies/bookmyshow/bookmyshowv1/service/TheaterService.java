package com.studies.bookmyshow.bookmyshowv1.service;

import com.studies.bookmyshow.bookmyshowv1.dao.TheaterDao;
import com.studies.bookmyshow.bookmyshowv1.dto.TheaterRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.TheaterResponseDto;
import com.studies.bookmyshow.bookmyshowv1.entity.TheaterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    private TheaterDao theaterDao;

    public TheaterResponseDto saveTheater(TheaterRequestDto theaterRequestDto){
        TheaterEntity theater = convertDtoToEntity(theaterRequestDto);
        TheaterEntity theaterEntity = theaterDao.saveTheater(theater);
        return convertEntityToDto(theaterEntity);
    }

    public List<TheaterResponseDto> getAllTheaters(){
        List<TheaterEntity> theaters = theaterDao.getAllTheaters();
        return convertEntityListToDtoList(theaters);
    }

    public TheaterResponseDto getTheaterById(int theaterId){
       TheaterEntity theater = theaterDao.getTheaterById(theaterId);
       return convertEntityToDto(theater);
    }

    private TheaterEntity convertDtoToEntity(TheaterRequestDto theaterRequestDto){
        return TheaterEntity.builder()
                .theaterId(theaterRequestDto.getTheaterId())
                .theaterName(theaterRequestDto.getTheaterName())
                .location(theaterRequestDto.getLocation())
                .city(theaterRequestDto.getCity())
                .build();
    }

    private TheaterResponseDto convertEntityToDto(TheaterEntity theaterEntity){
        return TheaterResponseDto.builder()
                .theaterId(theaterEntity.getTheaterId())
                .theaterName(theaterEntity.getTheaterName())
                .location(theaterEntity.getLocation())
                .city(theaterEntity.getCity())
                .build();
    }

    private List<TheaterResponseDto> convertEntityListToDtoList(List<TheaterEntity> theaterEntityList){
        List<TheaterResponseDto> theatersList = new ArrayList<>();
        for(TheaterEntity theater : theaterEntityList){
            TheaterResponseDto theaterResponse = new TheaterResponseDto();
            theaterResponse.setTheaterId(theater.getTheaterId());
            theaterResponse.setTheaterName(theater.getTheaterName());
            theaterResponse.setLocation(theater.getLocation());
            theaterResponse.setCity(theater.getCity());
            theatersList.add(theaterResponse);
        }
        return theatersList;

    }
}
