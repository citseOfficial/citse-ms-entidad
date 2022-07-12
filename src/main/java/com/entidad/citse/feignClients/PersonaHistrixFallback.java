package com.entidad.citse.feignClients;

import com.entidad.citse.models.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class PersonaHistrixFallback implements PersonaFeignClient{
    @Override
    public ResponseEntity<Persona> findById(int id) {
        Persona persona = Persona.builder().noPersona("none").apPaterno("none").apMaterno("none").build();
        return ResponseEntity.ok(persona);
    }
}
