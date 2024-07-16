package com.cloudinary.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudinary.springboot.model.ClaseMedia;
import com.cloudinary.springboot.model.ClaseMediaKey;

public interface IClaseMediaRepository extends JpaRepository<ClaseMedia, ClaseMediaKey>{
}
