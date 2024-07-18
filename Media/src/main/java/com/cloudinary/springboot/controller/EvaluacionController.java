package com.cloudinary.springboot.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cloudinary.springboot.model.Evaluaciones;
import com.cloudinary.springboot.service.impl.EvaluacionService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping ("/api/courses/evaluations")
public class EvaluacionController {

    @Autowired
    EvaluacionService evaluacionService;

    //Post
    @PostMapping
    public ResponseEntity<Evaluaciones> postEvaluaciones(@RequestBody Evaluaciones evaluaciones)
    {
        try {
            Evaluaciones createdEvaluacion = evaluacionService.createEvaluacion(evaluaciones);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdEvaluacion);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Get
    @GetMapping ("/{id}")
    public ResponseEntity<Evaluaciones> getEvaluaciones(@PathVariable ("id") String id)
    {
        Optional<Evaluaciones> evaluacion = evaluacionService.retrieveEvaluacion(id);
        if (evaluacion.isPresent())
        {
            return ResponseEntity.ok(evaluacion.get());
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    //GetAll
    @GetMapping
    public List<Evaluaciones> getAllEvaluaciones()
    {
        return evaluacionService.retrieveAllEvaluaciones();
    }

    //Update
    @PutMapping ("/{id}")
    public ResponseEntity<Evaluaciones> putEvaluaciones(@PathVariable String id, @RequestBody Evaluaciones evaluaciones)
    {
        try {
            Optional<Evaluaciones> updatedEvaluacion = evaluacionService.updateEvaluacion(id, evaluaciones);
            return updatedEvaluacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleEvaluacion(@PathVariable String id)
    {
        try {
            evaluacionService.deleteEvaluacion(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
