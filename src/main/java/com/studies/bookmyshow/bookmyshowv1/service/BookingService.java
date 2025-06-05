package com.studies.bookmyshow.bookmyshowv1.service;

import com.studies.bookmyshow.bookmyshowv1.dao.BookingDao;
import com.studies.bookmyshow.bookmyshowv1.dto.BookingRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.BookingResponseDto;
import com.studies.bookmyshow.bookmyshowv1.entity.BookingEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingDao bookingDao;

    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto){
        BookingEntity bookings = convertDtoToEntity(bookingRequestDto);
        BookingEntity savedBookings = bookingDao.createBooking(bookings);
        return convertEntityToDto(savedBookings);
    }

    public List<BookingResponseDto> getAllBookings(){
        List<BookingEntity> allBookings = bookingDao.getAllBookings();
        return convertEntitiesToDtos(allBookings);
    }

    public BookingResponseDto getBookingById(int id){
        BookingEntity bookingEntity = bookingDao.getBookingById(id);
        return convertEntityToDto(bookingEntity);
    }

    private BookingEntity convertDtoToEntity(BookingRequestDto bookingRequestDto){
        return BookingEntity.builder()
                .bookingId(bookingRequestDto.getBookingId())
                .userId(bookingRequestDto.getUserId())
                .showId(bookingRequestDto.getShowId())
                .bookingTime(bookingRequestDto.getBookingTime())
                .price(bookingRequestDto.getPrice())
                .status(bookingRequestDto.getStatus())
                .build();
    }

    private BookingResponseDto convertEntityToDto(BookingEntity bookingEntity){
        return BookingResponseDto.builder()
                .bookingId(bookingEntity.getBookingId())
                .bookingTime(bookingEntity.getBookingTime())
                .status(bookingEntity.getStatus())
                .price(bookingEntity.getPrice())
                .showId(bookingEntity.getShowId())
                .userId(bookingEntity.getUserId())
                .build();
    }

    private List<BookingResponseDto> convertEntitiesToDtos(List<BookingEntity> bookingEntities){
        List<BookingResponseDto> bookingResponseDtoList = new ArrayList<>();
        for(BookingEntity bookings : bookingEntities){
            BookingResponseDto bookingResponseDto = new BookingResponseDto();
            bookingResponseDto.setBookingId(bookings.getBookingId());
            bookingResponseDto.setBookingTime(bookings.getBookingTime());
            bookingResponseDto.setShowId(bookings.getShowId());
            bookingResponseDto.setUserId(bookings.getUserId());
            bookingResponseDto.setStatus(bookings.getStatus());
            bookingResponseDto.setPrice(bookings.getPrice());
            bookingResponseDtoList.add(bookingResponseDto);
        }
        return bookingResponseDtoList;
    }
}
