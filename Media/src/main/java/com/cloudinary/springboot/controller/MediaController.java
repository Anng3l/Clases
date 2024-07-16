package com.cloudinary.springboot.controller;

import com.cloudinary.springboot.dto.MediaModel;
import com.cloudinary.springboot.model.Media;
import com.cloudinary.springboot.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RequestMapping ("/api/courses/clases/media")
@RestController
public class MediaController {
    
    @Autowired
    private MediaService mediaService;

    @PostMapping("/upload")
    public ResponseEntity<Map> upload(
            @RequestParam("id") String id,
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file,
            @RequestParam("type") String type
            ) {
        try {
            MediaModel mediaModel = new MediaModel();
            mediaModel.setId(id);
            mediaModel.setTitle(title);
            mediaModel.setDescription(description);
            mediaModel.setFile(file);
            mediaModel.setType(type);
            return mediaService.uploadMedia(mediaModel);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping ("/get/{id}")
    public ResponseEntity<Media> retrieve(@PathVariable ("id") String id)
    {
        Media media = mediaService.retrieveMedia(id);
        if (media != null) {
            return ResponseEntity.ok(media);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping ("/update/{id}")
    public ResponseEntity<Media> update(
            @PathVariable ("id") String id,
            @RequestParam("title") String title,
            @RequestParam("description") String description
            ) {
        try {
            MediaModel mediaModel = new MediaModel();
            mediaModel.setId(id);
            mediaModel.setTitle(title);
            mediaModel.setDescription(description);
            
            Media updatedMedia = mediaService.updateMedia(mediaModel);
            if (updatedMedia != null) 
            {
                return ResponseEntity.ok(updatedMedia);
            }
            else
            {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") String id)
    {
        try {
            mediaService.deleteMedia(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }
}
