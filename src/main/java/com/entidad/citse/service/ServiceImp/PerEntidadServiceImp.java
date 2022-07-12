package com.entidad.citse.service.ServiceImp;

import com.entidad.citse.dao.PersonaEntidadDao;
import com.entidad.citse.entity.PersonaEntidad;
import com.entidad.citse.feignClients.PersonaFeignClient;
import com.entidad.citse.models.Persona;
import com.entidad.citse.service.PersonaEntidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerEntidadServiceImp implements PersonaEntidadService {

    @Autowired
    private PersonaEntidadDao repo;

    @Autowired
    private PersonaFeignClient personaFeignClient;

    @Override
    public List<PersonaEntidad> findAll() {
        return repo.findAll();
    }

    @Override
    public PersonaEntidad findById(Integer id) {
        PersonaEntidad pe = repo.findById(id).orElse(null);
        if(pe !=null){
            Persona persona = personaFeignClient.findById(pe.getIdPersona()).getBody();
            pe.setPersona(persona);
        }
        return pe;
    }

    @Override
    public PersonaEntidad save(PersonaEntidad personaEntidad) {
        return repo.save(personaEntidad);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}
