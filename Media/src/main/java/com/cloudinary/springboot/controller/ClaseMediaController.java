package com.cloudinary.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cloudinary.springboot.model.ClaseMedia;
import com.cloudinary.springboot.model.ClaseMediaKey;
import com.cloudinary.springboot.service.impl.ClaseMediaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses/clases/clases_media")
public class ClaseMediaController {

    @Autowired
    private ClaseMediaService claseMediaService;

    @GetMapping
    public List<ClaseMedia> getAllClaseMedia() {
        return claseMediaService.getAllClaseMedia();
    }

    @GetMapping("/{claseId}/{mediaId}")
    public ResponseEntity<ClaseMedia> getClaseMedia(@PathVariable Integer claseId, @PathVariable String mediaId) {
        ClaseMediaKey id = new ClaseMediaKey();
        id.setClaseId(claseId);
        id.setMediaId(mediaId);

        Optional<ClaseMedia> claseMedia = claseMediaService.getClaseMedia(id);
        return claseMedia.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ClaseMedia createClaseMedia(@RequestParam Integer claseId, @RequestParam String mediaId) {
        return claseMediaService.createClaseMedia(claseId, mediaId);
    }

    @DeleteMapping("/{claseId}/{mediaId}")
    public ResponseEntity<Void> deleteClaseMedia(@PathVariable Integer claseId, @PathVariable String mediaId) {
        ClaseMediaKey id = new ClaseMediaKey();
        id.setClaseId(claseId);
        id.setMediaId(mediaId);

        claseMediaService.deleteClaseMedia(id);
        return ResponseEntity.noContent().build();
    }
}
