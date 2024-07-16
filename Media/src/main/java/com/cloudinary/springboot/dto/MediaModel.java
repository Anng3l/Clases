package com.cloudinary.springboot.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MediaModel {
    private String id;
    private String title;
    private String description;
    private MultipartFile file;
    private String url;
    private String type; // "image" or "video"


    public MediaModel(String id, String title, String description, MultipartFile file, String url, String type) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.file = file;
        this.url = url;
        this.type = type;
    }
    
    public MediaModel() {
    }
}