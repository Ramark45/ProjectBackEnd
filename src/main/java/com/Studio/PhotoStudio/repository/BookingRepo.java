package com.Studio.PhotoStudio.repository;

import com.Studio.PhotoStudio.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
}