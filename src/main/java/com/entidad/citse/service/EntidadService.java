package com.entidad.citse.service;

import com.entidad.citse.entity.Entidad;

import java.util.List;

public interface EntidadService {
    public List<Entidad> findAll();
    public Entidad findById(Integer id);
    public void deleteById(Integer id);

    public List<Entidad> findByAlias(String alias);
    public List<Entidad> findByNombre(String nombre);
    public Entidad save(Entidad entidad);
}
