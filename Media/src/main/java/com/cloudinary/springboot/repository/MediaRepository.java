package com.cloudinary.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudinary.springboot.model.Media;


@Repository
public interface MediaRepository extends JpaRepository<Media, String> {
}