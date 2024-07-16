package com.cloudinary.springboot.model;

import java.util.List;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Media")
public class Media {
    @Id
    @Column(name = "id_media", columnDefinition = "VARCHAR(5)", nullable = false)
    private String id;

    @Column(name = "titulo_media")
    private String title;

    @Column(name= "descripcion_media")
    private String description;

    @Column(name = "url_media")
    private String url;

    @Column(name = "tipo_media")
    private String type; // "image" or "video"

    @ManyToMany (mappedBy = "medias")
    private List<Clases> clases;
}
