package com.entidad.citse.dao;

import com.entidad.citse.entity.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntidadDao extends JpaRepository<Entidad,Integer> {
    //@Query("SELECT e FROM Entidad e WHERE (alias like %:query% or co_alias like %:query%)")
    public List<Entidad> findTop10ByAliasContains(String alias);
    public List<Entidad> findTop10ByNombreContains(String nombre);
}
