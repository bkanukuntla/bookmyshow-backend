package com.studies.bookmyshow.bookmyshowv1.controller;

import com.studies.bookmyshow.bookmyshowv1.dto.BookingRequestDto;
import com.studies.bookmyshow.bookmyshowv1.dto.BookingResponseDto;
import com.studies.bookmyshow.bookmyshowv1.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/createBooking")
    public BookingResponseDto createBooking(@RequestBody BookingRequestDto bookingRequestDto){
        return bookingService.createBooking(bookingRequestDto);
    }

    @GetMapping("/getAllMovies")
    public List<BookingResponseDto> getAllBookings(){
        return bookingService.getAllBookings();
    }

    @GetMapping("/getBookingById/{id}")
    public BookingResponseDto getBookingById(@PathVariable("id") int id){
        return bookingService.getBookingById(id);
    }
}
