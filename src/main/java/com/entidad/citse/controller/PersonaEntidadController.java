package com.entidad.citse.controller;

import com.entidad.citse.entity.PersonaEntidad;
import com.entidad.citse.service.PersonaEntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("personaEntidad")
public class PersonaEntidadController {

    @Autowired
    private PersonaEntidadService service;

    @GetMapping
    public List<PersonaEntidad> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PersonaEntidad findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    public PersonaEntidad save(@RequestBody PersonaEntidad personaEntidad){
        return service.save(personaEntidad);
    }

    @PutMapping("/{id}")
    public PersonaEntidad update(@RequestBody PersonaEntidad personaEntidad, @PathVariable Integer id){
        PersonaEntidad pe = service.findById(id);
        pe.setEntidad(personaEntidad.getEntidad());
        pe.setPersona(personaEntidad.getPersona());
        service.save(pe);
        return pe;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteById(id);
    }
}
