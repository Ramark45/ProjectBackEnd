package com.Prograd.springjwt.security.services;

import com.Prograd.springjwt.models.Booking;
import com.Prograd.springjwt.models.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StatusService {

    Status saveStatus(Status status);
    List<Status> getAllStatus();
    Status getStatusById(int id);
    void deleteStatus(int id);
}