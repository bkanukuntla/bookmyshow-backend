package com.studies.bookmyshow.bookmyshowv1.dao;

import com.studies.bookmyshow.bookmyshowv1.dto.TheaterRequestDto;
import com.studies.bookmyshow.bookmyshowv1.entity.TheaterEntity;
import com.studies.bookmyshow.bookmyshowv1.repository.TheaterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class TheaterDao {

    private final TheaterRepository theaterRepository;

    public TheaterEntity saveTheater(TheaterEntity theaterEntity){
        return theaterRepository.save(theaterEntity);
    }

    public List<TheaterEntity> getAllTheaters(){
       return theaterRepository.findAll();
    }

    public TheaterEntity getTheaterById(int theaterId){
        return theaterRepository.findByTheaterId(theaterId);
    }
}
