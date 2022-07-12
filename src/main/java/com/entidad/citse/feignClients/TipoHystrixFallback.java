package com.entidad.citse.feignClients;

import com.entidad.citse.models.Tipo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class TipoHystrixFallback implements TipoFeignClient{
    @Override
    public ResponseEntity<Tipo> findById(Integer id) {
        Tipo tipo = Tipo.builder().noTipo("none").coAlias("none").build();
        return ResponseEntity.ok(tipo);
    }
}
