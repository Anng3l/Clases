package com.cloudinary.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cloudinary.springboot.model.Clases;
import com.cloudinary.springboot.repository.IClasesRepository;

@Service
public class ClaseService {

    @Autowired
    IClasesRepository clasesRepository;

    //Create
    public void setClaseInformacion(Clases clases)
    {
        clasesRepository.save(clases);
    }

    //Get
    public Clases getClaseInformacion(int id_clase)
    {
        return clasesRepository.findById(id_clase).get();
    }

    //Put
    public void putClaseInformacion(Clases clases)
    {
        clasesRepository.save(clases);
    }

    //Delete
    public void deleteClaseInformacion(Integer id_Clase)
    {
        clasesRepository.deleteById(id_Clase);
    }

    //Get All
    public List<Clases> getAllClasesInformacion()
    {
        return clasesRepository.findAll();
    }
}
