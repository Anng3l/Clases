package com.cloudinary.springboot.model;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "clase_media")
public class ClaseMedia implements Serializable {

    @EmbeddedId
    private ClaseMediaKey id;

    @ManyToOne
    @MapsId("claseId")
    @JoinColumn(name = "id_clase")
    private Clases clase;

    @ManyToOne
    @MapsId("mediaId")
    @JoinColumn(name = "id")
    private Media media;

}