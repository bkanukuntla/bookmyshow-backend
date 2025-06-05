package com.studies.bookmyshow.bookmyshowv1.dao;

import com.studies.bookmyshow.bookmyshowv1.entity.BookingEntity;
import com.studies.bookmyshow.bookmyshowv1.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
public class BookingDao {

    @Autowired
    private BookingRepository bookingRepository;

    public BookingEntity createBooking(BookingEntity bookingEntity){
        return bookingRepository.save(bookingEntity);
    }

    public List<BookingEntity> getAllBookings(){
        return bookingRepository.findAll();
    }

    public BookingEntity getBookingById(int id){
        return bookingRepository.findByBookingId(id);
    }
}
