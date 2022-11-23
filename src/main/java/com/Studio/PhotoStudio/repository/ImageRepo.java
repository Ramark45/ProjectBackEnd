package com.Studio.PhotoStudio.repository;

import com.Studio.PhotoStudio.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long> {

}
