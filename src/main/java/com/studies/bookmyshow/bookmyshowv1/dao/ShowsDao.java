package com.studies.bookmyshow.bookmyshowv1.dao;

import com.studies.bookmyshow.bookmyshowv1.entity.ShowsEntity;
import com.studies.bookmyshow.bookmyshowv1.repository.ShowsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ShowsDao {

    @Autowired
    private ShowsRepository showsRepository;

    public ShowsEntity createShow(ShowsEntity showsEntity){
        return showsRepository.save(showsEntity);
    }

    public List<ShowsEntity> getAllShows(){
        return showsRepository.findAll();
    }

    public ShowsEntity getShowsById(int showId){
        return showsRepository.findByShowId(showId);
    }
}
