package com.cloudinary.springboot.service;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
    public String uploadFile(MultipartFile file, String folderName, String resourceType);
}
