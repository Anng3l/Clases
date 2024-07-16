package com.cloudinary.springboot.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Clase")
public class Clases {
    /*
    public Clases(int id_clase, String titulo, String descripcion)
    {
        this.id_clase = id_clase;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }
    
    public Clases()
    {}
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_clase;

    @Column
    private String titulo;

    @Column
    private String descripcion;


    @ManyToMany
    @JoinTable(
        name = "clase_media",
        joinColumns = @JoinColumn(name = "id_clase"),
        inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Media> medias;

}