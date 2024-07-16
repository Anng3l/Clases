package com.cloudinary.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudinary.springboot.model.ClaseMedia;
import com.cloudinary.springboot.model.ClaseMediaKey;
import com.cloudinary.springboot.model.Clases;
import com.cloudinary.springboot.model.Media;
import com.cloudinary.springboot.repository.IClaseMediaRepository;
import com.cloudinary.springboot.repository.IClasesRepository;
import com.cloudinary.springboot.repository.MediaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseMediaService {

    @Autowired
    private IClaseMediaRepository claseMediaRepository;

    @Autowired
    private IClasesRepository claseRepository;

    @Autowired
    private MediaRepository mediaRepository;

    public List<ClaseMedia> getAllClaseMedia() {
        return claseMediaRepository.findAll();
    }

    public Optional<ClaseMedia> getClaseMedia(ClaseMediaKey id) {
        return claseMediaRepository.findById(id);
    }

    public ClaseMedia createClaseMedia(Integer claseId, String mediaId) {
        Clases clase = claseRepository.findById(claseId).orElseThrow(() -> new RuntimeException("Clase no encontrada"));
        Media media = mediaRepository.findById(mediaId).orElseThrow(() -> new RuntimeException("Media no encontrada"));

        ClaseMediaKey id = new ClaseMediaKey();
        id.setClaseId(claseId);
        id.setMediaId(mediaId);

        ClaseMedia claseMedia = new ClaseMedia();
        claseMedia.setId(id);
        claseMedia.setClase(clase);
        claseMedia.setMedia(media);

        return claseMediaRepository.save(claseMedia);
    }

    public void deleteClaseMedia(ClaseMediaKey id) {
        claseMediaRepository.deleteById(id);
    }
}
