package com.example.cinnamon_cinema_backend.controllers;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final String imagePath = "src/main/resources/static/images/";

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> getImage(String filename) throws MalformedURLException {
        Resource resource = new UrlResource(imagePath + filename);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + filename + "\"")
                .body(resource);
    }
}
