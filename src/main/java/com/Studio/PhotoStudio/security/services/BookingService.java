package com.Studio.PhotoStudio.security.services;

import com.Studio.PhotoStudio.models.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();
    Booking getBookingById(int id);
    void deleteBooking(int id);
    Booking updateBooking(Booking booking,int id);


}