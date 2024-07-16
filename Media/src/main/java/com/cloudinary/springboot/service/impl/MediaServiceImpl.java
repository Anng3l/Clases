package com.cloudinary.springboot.service.impl;

import com.cloudinary.springboot.dto.MediaModel;
import com.cloudinary.springboot.model.Media;
import com.cloudinary.springboot.repository.MediaRepository;
import com.cloudinary.springboot.service.CloudinaryService;
import com.cloudinary.springboot.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private MediaRepository mediaRepository;

    @Override
    public ResponseEntity<Map> uploadMedia(MediaModel mediaModel) {
        try {
            // Validaciones más detalladas
            if (mediaModel.getTitle() == null || mediaModel.getTitle().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "El nombre no puede estar vacío"));
            }
            if (mediaModel.getFile() == null || mediaModel.getFile().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "El archivo no puede estar vacío"));
            }
            if (mediaModel.getType() == null || mediaModel.getType().isEmpty()) {
                return ResponseEntity.badRequest().body(Map.of("error", "El tipo no puede estar vacío"));
            }

            Media media = new Media();
            media.setId(mediaModel.getId());
            media.setTitle(mediaModel.getTitle());
            media.setDescription(mediaModel.getDescription());
            String folderName = "";
            String resourceType = mediaModel.getType().equalsIgnoreCase("video") ? "video" : "image";
            media.setType(mediaModel.getType());
            if (resourceType.equalsIgnoreCase("video"))
            {
                folderName = "videos";
            }
            else
            {
                folderName = "pictures";
            }
            media.setUrl(cloudinaryService.uploadFile(mediaModel.getFile(), folderName, resourceType));
            

            if (media.getUrl() == null) {
                return ResponseEntity.badRequest().body(Map.of("error", "Error al subir el archivo"));
            }

            mediaRepository.save(media);
            return ResponseEntity.ok().body(Map.of("url", media.getUrl()));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(Map.of("error", "Error interno del servidor"));
        }
    }

    @Override
    public Media retrieveMedia(String id) {
        Optional<Media> mediaOptional = mediaRepository.findById(id);
        return mediaOptional.orElse(null);
    }

    @Override
    public Media updateMedia(MediaModel mediaModel) {
        Optional<Media> mediaOptional = mediaRepository.findById(mediaModel.getId());
        if (mediaOptional.isPresent()) {
            Media media = mediaOptional.get();
            if (mediaModel.getTitle() != null && !mediaModel.getTitle().isEmpty()) {
                media.setTitle(mediaModel.getTitle());
            }
            if (mediaModel.getTitle() != null && !mediaModel.getTitle().isEmpty()) {
                media.setTitle(mediaModel.getTitle());
            }
            if (mediaModel.getDescription() != null && !mediaModel.getDescription().isEmpty()) {
                media.setDescription(mediaModel.getDescription());
            }
            mediaRepository.save(media);
            return media;
        }
        return null;
    }

    @Override
    public void deleteMedia(String id) {
        mediaRepository.deleteById(id);
    }
}
