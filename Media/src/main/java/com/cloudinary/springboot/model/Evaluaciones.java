package com.cloudinary.springboot.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Evaluaciones {

    @Id
    private String id;

    @Column
    private String nombre;
    @Column
    private String descripcion;

    @ElementCollection
    @Column
    private List<String> preguntas;
    @ElementCollection
    @Column
    private List<String> respuestas;

    @Column (columnDefinition = "INT")
    private Integer calificacion_maxima;
    @Column (columnDefinition = "FLOAT(5, 2)")
    private Integer nota_estudiante;
    @Column
    private LocalDateTime fecha_inicio;
    @Column
    private LocalDateTime fecha_fin;

    @Enumerated(EnumType.STRING)
    @Column
    private Estado estado;


}
