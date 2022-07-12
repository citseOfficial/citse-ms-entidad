package com.entidad.citse.feignClients;

import com.entidad.citse.models.Persona;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "citse-ms-maestra", path = "/persona",fallback = PersonaHistrixFallback.class)
public interface PersonaFeignClient {

    @GetMapping("/{id}")
    public ResponseEntity<Persona> findById(@PathVariable int id);
}
