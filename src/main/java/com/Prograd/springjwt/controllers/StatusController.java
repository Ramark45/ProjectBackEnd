package com.Prograd.springjwt.controllers;


import com.Prograd.springjwt.models.Booking;
import com.Prograd.springjwt.models.Status;
import com.Prograd.springjwt.security.services.BookingService;
import com.Prograd.springjwt.security.services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
@RequestMapping("/api/test/booking/status")
public class StatusController {
    @Autowired
    private StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Status> saveStatus(@RequestBody Status status)
    {
        System.out.println(status);
        return new ResponseEntity<Status>(statusService.saveStatus(status), HttpStatus.CREATED);
    }
    @GetMapping("/bookingStatus")
    public List<Status> getAllStatus()
    {
        return statusService.getAllStatus();
    }
    @GetMapping("{id}")
    public ResponseEntity<Status> getStatusById(@PathVariable("id")int id)
    {
        return new ResponseEntity<Status>(statusService.getStatusById(id),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStatus(@PathVariable("id")int id)
    {
        statusService.deleteStatus(id);
        return new ResponseEntity<String>("Student deleted successfully",HttpStatus.OK);
    }
}
