package com.imagegallery;

import java.io.File;

import com.imagegallery.controller.ImageController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"package com.imagegallery","controller"})
public class Application {

	public static void main(String[] args) {
		new File(ImageController.uploadDir).mkdir();
		SpringApplication.run(Application.class, args);
	}

}
