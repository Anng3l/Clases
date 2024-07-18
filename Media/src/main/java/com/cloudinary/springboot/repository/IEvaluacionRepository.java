package com.cloudinary.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cloudinary.springboot.model.Evaluaciones;

@Repository
public interface IEvaluacionRepository extends JpaRepository<Evaluaciones, String> {

}
