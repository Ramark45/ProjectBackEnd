package com.Prograd.springjwt.security.services;

import com.Prograd.springjwt.models.Image;
import com.Prograd.springjwt.repository.ImageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImageServiceImpl implements ImageService{
    @Autowired
    private ImageRepo imageRepo;

    public ImageServiceImpl(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }
    @Override
    public Image saveImage(Image image)
    {
        return imageRepo.save(image);
    }

    @Override
    public List<Image> getAllImages() {
        return imageRepo.findAll();
    }

    @Override
    public Image getImageById(int id) {
        return null;
    }

    @Override
    public void deleteImage(Long id)
    {
        imageRepo.findById(id);
        imageRepo.deleteById(id);
    }
}
