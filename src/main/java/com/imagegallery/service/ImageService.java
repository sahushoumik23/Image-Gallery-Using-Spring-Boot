package com.imagegallery.service;

import java.util.List;

import com.imagegallery.model.ImageGallery;
import com.imagegallery.repository.ImageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService
{
    @Autowired
    private ImageRepository imageRepository;

    public List<ImageGallery> getAllImages()
    {
        return imageRepository.findAll();
    }

    public void removeImage(Long id)
    {
        imageRepository.deleteById(id);
    }

    public void addImage(ImageGallery imageGallery)
    {
        imageRepository.save(imageGallery);
    }
    
}
