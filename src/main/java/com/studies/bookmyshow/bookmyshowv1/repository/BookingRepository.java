package com.studies.bookmyshow.bookmyshowv1.repository;

import com.studies.bookmyshow.bookmyshowv1.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    public BookingEntity findByBookingId(int id);
}
