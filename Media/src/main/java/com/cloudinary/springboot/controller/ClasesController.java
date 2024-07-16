package com.cloudinary.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cloudinary.springboot.model.Clases;
import com.cloudinary.springboot.service.impl.ClaseService;

@RestController
@RequestMapping (path = "/api/courses/clases")
public class ClasesController {
    
    ClaseService claseService;

    public ClasesController(ClaseService claseService)
    {
        this.claseService = claseService;
    }


    //Create
    @PostMapping
    public void createClasesInfo(@RequestBody Clases clases)
    {
        claseService.setClaseInformacion(clases);
    }

    //Get
    @GetMapping ("/{id_clase}")
    public Clases readClasesInfo(@PathVariable ("id_clase") Integer id_clase)
    {
        return claseService.getClaseInformacion(id_clase);
    }

    //Put
    @PutMapping
    public void updateClasesInfo(@RequestBody Clases clases)
    {
        claseService.putClaseInformacion(clases);
    }

    //Delete
    @DeleteMapping ("/{id_clase}")
    public void delClasesInfo(@PathVariable ("id_clase") Integer id_clase)
    {
        claseService.deleteClaseInformacion(id_clase);
    }


    //Get All
    @GetMapping
    public List<Clases> readAllClasesInfo()
    {
        return claseService.getAllClasesInformacion();
    }
}
