package com.Prograd.springjwt.controllers;

import com.Prograd.springjwt.models.Booking;
import com.Prograd.springjwt.models.Image;
import com.Prograd.springjwt.security.services.BookingService;
import com.Prograd.springjwt.security.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/test/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Booking> saveBooking(@RequestBody Booking booking)
    {
        System.out.println(booking);
        return new ResponseEntity<Booking>(bookingService.saveBooking(booking), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Booking> getAllBookings()
    {
        return bookingService.getAllBookings();
    }
    @GetMapping("{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Booking>(bookingService.getBookingById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable("id")int id,@RequestBody Booking booking)
    {
        return new ResponseEntity<Booking>(bookingService.updateBooking(booking,id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBooking(@PathVariable("id")int id)
    {
        bookingService.deleteBooking(id);
        return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
    }
}
