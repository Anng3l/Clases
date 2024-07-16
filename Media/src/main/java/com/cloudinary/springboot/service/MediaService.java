package com.cloudinary.springboot.service;

import com.cloudinary.springboot.dto.MediaModel;
import com.cloudinary.springboot.model.Media;

import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface MediaService {
    public ResponseEntity<Map> uploadMedia(MediaModel mediaModel);

    public Media retrieveMedia(String id);

    public Media updateMedia(MediaModel mediaModel);

    public void deleteMedia(String id);
}
