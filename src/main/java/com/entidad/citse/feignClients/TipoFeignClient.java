package com.entidad.citse.feignClients;

import com.entidad.citse.models.Tipo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "citse-ms-tipo",path = "/tipo")
public interface TipoFeignClient {
    @GetMapping("/{id}")
    public ResponseEntity<Tipo> findById(@PathVariable Integer id);
}
