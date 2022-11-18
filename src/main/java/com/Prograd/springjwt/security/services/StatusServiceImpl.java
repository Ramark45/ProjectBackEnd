package com.Prograd.springjwt.security.services;


import com.Prograd.springjwt.models.Booking;
import com.Prograd.springjwt.models.Status;
import com.Prograd.springjwt.repository.BookingRepo;
import com.Prograd.springjwt.repository.StatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService{
    @Autowired
    private StatusRepo statusRepo;

    public StatusServiceImpl(StatusRepo statusRepo) {
        this.statusRepo = statusRepo;
    }
    @Override
    public Status saveStatus(Status status)
    {
        return statusRepo.save(status);
    }

    @Override
    public List<Status> getAllStatus() {
        return statusRepo.findAll();
    }
    @Override
    public void deleteStatus(int id)
    {
        statusRepo.findById(id);
        statusRepo.deleteById(id);
    }

    @Override
    public Status getStatusById(int id) {
        return null;
    }


}
