package com.entidad.citse.controller;

import com.entidad.citse.entity.Entidad;
import com.entidad.citse.service.EntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("entidad")
public class EntidadController {

    @Autowired
    private EntidadService service;

    @GetMapping
    public ResponseEntity<List<Entidad> > findAll(@RequestParam(name = "alias",required = false)String alias,
                                                  @RequestParam(name = "nombre",required = false)String nombre){
        List<Entidad> e = new ArrayList<>();
        if(alias==null && nombre==null){
            e=service.findAll();
            if(e.isEmpty())
                return ResponseEntity.noContent().build();
        }else if(alias!=null){
            e=service.findByAlias(alias);
            if(e.isEmpty())
                return ResponseEntity.notFound().build();
        }else{
            e=service.findByNombre(nombre);
            if(e.isEmpty())
                return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(e);
    }
    @GetMapping("/{id}")
    public Entidad findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping
    public Entidad save(@RequestBody Entidad entidad){
        return service.save(entidad);
    }
    @PutMapping("/{id}")
    public Entidad update(@RequestBody Entidad entidad, @PathVariable Integer id){
        Entidad e= service.findById(id);
        e.setFeInstancia(entidad.getFeInstancia());
        e.setIdPadre(entidad.getIdPadre());
        e.setAlias(entidad.getAlias());
        e.setNombre(e.getNombre());
        e.setIdTipoEntidad(entidad.getIdTipoEntidad());
        service.save(e);
        return e;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteById(id);
    }
}
