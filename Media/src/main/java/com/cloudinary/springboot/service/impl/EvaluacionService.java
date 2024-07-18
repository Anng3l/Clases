package com.cloudinary.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloudinary.springboot.model.Evaluaciones;
import com.cloudinary.springboot.repository.IEvaluacionRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EvaluacionService {

    @Autowired
    private IEvaluacionRepository evaluacionRepository;

    // Crear evaluación
    @Transactional
    public Evaluaciones createEvaluacion(Evaluaciones evaluaciones) {
        return evaluacionRepository.save(evaluaciones);
    }

    // Recuperar una evaluación por ID
    @Transactional(readOnly = true)
    public Optional<Evaluaciones> retrieveEvaluacion(String id) {
        return evaluacionRepository.findById(id);
    }

    // Recuperar todas las evaluaciones
    public List<Evaluaciones> retrieveAllEvaluaciones() {
        return evaluacionRepository.findAll();
    }

    // Actualizar evaluación
    @Transactional
    public Optional<Evaluaciones> updateEvaluacion(String id, Evaluaciones evaluacionActualizado) {
        return evaluacionRepository.findById(id).map(evaluacion -> {
            evaluacion.setNombre(evaluacionActualizado.getNombre());
            evaluacion.setDescripcion(evaluacionActualizado.getDescripcion());
            evaluacion.setPreguntas(evaluacionActualizado.getPreguntas());
            evaluacion.setRespuestas(evaluacionActualizado.getRespuestas());
            evaluacion.setCalificacion_maxima(evaluacionActualizado.getCalificacion_maxima());
            evaluacion.setNota_estudiante(evaluacionActualizado.getNota_estudiante());
            evaluacion.setFecha_inicio(evaluacionActualizado.getFecha_inicio());
            evaluacion.setFecha_fin(evaluacionActualizado.getFecha_fin());
            evaluacion.setEstado(evaluacionActualizado.getEstado());
            return evaluacionRepository.save(evaluacion);
        });
    }

    // Eliminar evaluación por ID
    @Transactional
    public void deleteEvaluacion(String id) {
        if (evaluacionRepository.existsById(id)) {
            evaluacionRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Evaluation not found with id: " + id);
        }
    }
}