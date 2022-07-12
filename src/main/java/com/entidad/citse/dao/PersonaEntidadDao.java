package com.entidad.citse.dao;

import com.entidad.citse.entity.PersonaEntidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaEntidadDao extends JpaRepository<PersonaEntidad,Integer> {
}
