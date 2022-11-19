package com.Prograd.springjwt.security.services;

import com.Prograd.springjwt.models.Booking;
import com.Prograd.springjwt.models.Image;
import com.Prograd.springjwt.repository.BookingRepo;
import com.Prograd.springjwt.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService{
    @Autowired
    private BookingRepo bookingRepo;

    public BookingServiceImpl(BookingRepo bookingRepo) {
        this.bookingRepo = bookingRepo;
    }
    @Override
    public Booking saveBooking(Booking booking)
    {
        return bookingRepo.save(booking);
    }
    @Override
    public Booking updateBooking(Booking booking,int id)
    {
        Booking existingBooking=bookingRepo.findById(id).orElseThrow();
        existingBooking.setFirstName(booking.getFirstName());
        existingBooking.setLastName(booking.getLastName());
        existingBooking.setAddress(booking.getAddress());
        existingBooking.setInfo(booking.getInfo());
        existingBooking.setCity(booking.getCity());
        existingBooking.setMobile(booking.getMobile());
        existingBooking.setDate(booking.getDate());
        existingBooking.setType(booking.getType());
        existingBooking.setAmount(booking.getAmount());

//        existingBooking.setStatus(booking.getStatus());
        bookingRepo.save(existingBooking);
        return existingBooking;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }
    @Override
    public void deleteBooking(int id)
    {
        bookingRepo.findById(id);
        bookingRepo.deleteById(id);
    }

    @Override
    public Booking getBookingById(int id) {
        return bookingRepo.findById(id).orElseThrow();
    }


}
