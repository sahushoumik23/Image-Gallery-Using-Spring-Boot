package com.imagegallery.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.imagegallery.model.ImageGallery;
import com.imagegallery.service.ImageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ImageController 
{
    public static String uploadDir=System.getProperty("user.dir") + "/src/main/resources/static/Images";

    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public String showImages(Model model)
    {
        model.addAttribute("images",imageService.getAllImages());
        return "images";
    }

    @GetMapping("/images/add")
    public String imageAdd(Model model)
    {
        model.addAttribute("imageGallery",new ImageGallery());
        return "imageAdd";
    }

    @PostMapping("/images/add")
    public String productAdd(@ModelAttribute("imageGallery") ImageGallery imageGallery,@RequestParam ("image") MultipartFile file,@RequestParam ("imgName") String imgName) throws IOException
    {
        String imageUUID;
        ImageGallery images=new ImageGallery();
        images.getId();

        if(!file.isEmpty())
        {
            imageUUID=file.getOriginalFilename();
            Path fileNameAndPath=Paths.get(uploadDir,imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        }
        else
        {
            imageUUID=imgName;
        }
        images.setImageName(imageUUID);
        imageService.addImage(images);
        return "redirect:/";
    }

    @GetMapping("/images/delete/{id}")
    public String deleteImage(@PathVariable Long id)
    {
        imageService.removeImage(id);
        return "redirect:/";
    }
}
