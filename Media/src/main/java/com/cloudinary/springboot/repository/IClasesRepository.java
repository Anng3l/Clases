package com.cloudinary.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudinary.springboot.model.Clases;

public interface IClasesRepository extends JpaRepository<Clases, Integer>{
    
}
