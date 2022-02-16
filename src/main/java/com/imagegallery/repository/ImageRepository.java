package com.imagegallery.repository;

import com.imagegallery.model.ImageGallery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<ImageGallery,Long>
{
    
}
