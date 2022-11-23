package com.Studio.PhotoStudio.security.services;

import com.Studio.PhotoStudio.models.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {

    Image saveImage(Image image);
    List<Image> getAllImages();
    Image getImageById(int id);
    void deleteImage(Long id);
}
