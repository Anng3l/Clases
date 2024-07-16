package com.cloudinary.springboot.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import lombok.Data;

@Data
@jakarta.persistence.Embeddable
public class ClaseMediaKey implements Serializable {

    @Column(name = "id_clase")
    private int claseId;

    @Column(name = "id")
    private String mediaId;
}