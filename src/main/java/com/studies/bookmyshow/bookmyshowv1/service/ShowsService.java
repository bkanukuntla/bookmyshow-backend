package com.studies.bookmyshow.bookmyshowv1.service;

import com.studies.bookmyshow.bookmyshowv1.dao.ShowsDao;
import com.studies.bookmyshow.bookmyshowv1.dto.ShowsRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.ShowsResponseDto;
import com.studies.bookmyshow.bookmyshowv1.entity.ShowsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowsService {
    @Autowired
    private ShowsDao showsDao;

    public ShowsResponseDto createShow(ShowsRequestDto showsRequestDto){
        ShowsEntity shows = convertDtoToEntity(showsRequestDto);
        ShowsEntity createdShow = showsDao.createShow(shows);
        return convertEntityToDto(createdShow);
    }

    public List<ShowsResponseDto> getAllShows(){
       List<ShowsEntity> allShows =  showsDao.getAllShows();
       return convertEntityListToDtoList(allShows);
    }

    public ShowsResponseDto getShowsById(int showId){
        ShowsEntity showsById = showsDao.getShowsById(showId);
        return convertEntityToDto(showsById);
    }

    private ShowsEntity convertDtoToEntity(ShowsRequestDto showsRequestDto){
        return ShowsEntity.builder()
                .showId(showsRequestDto.getShowId())
                .movieId(showsRequestDto.getMovieId())
                .screenId(showsRequestDto.getScreenId())
                .language(showsRequestDto.getLanguage())
                .endTime(showsRequestDto.getEndTime())
                .showType(showsRequestDto.getShowType())
                .startTime(showsRequestDto.getStartTime())
                .build();
    }

    private ShowsResponseDto convertEntityToDto(ShowsEntity showsEntity){
        return ShowsResponseDto.builder()
                .showId(showsEntity.getShowId())
                .movieId(showsEntity.getMovieId())
                .screenId(showsEntity.getScreenId())
                .startTime(showsEntity.getStartTime())
                .endTime(showsEntity.getEndTime())
                .language(showsEntity.getLanguage())
                .showType(showsEntity.getShowType())
                .build();
    }

    private List<ShowsResponseDto> convertEntityListToDtoList(List<ShowsEntity> showsEntityList){
        List<ShowsResponseDto> showsResponseDtoList = new ArrayList<>();
        for(ShowsEntity shows : showsEntityList){
            ShowsResponseDto showsResponseDto = new ShowsResponseDto();
            showsResponseDto.setShowId(shows.getShowId());
            showsResponseDto.setMovieId(shows.getMovieId());
            showsResponseDto.setScreenId(shows.getScreenId());
            showsResponseDto.setLanguage(shows.getLanguage());
            showsResponseDto.setStartTime(shows.getStartTime());
            showsResponseDto.setEndTime(shows.getStartTime());
            showsResponseDto.setShowType(shows.getShowType());
            showsResponseDtoList.add(showsResponseDto);
        }
        return showsResponseDtoList;
    }
}
