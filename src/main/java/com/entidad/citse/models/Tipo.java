package com.entidad.citse.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class Tipo {
    private Integer idTipo;
    private String noTipo;
    private String coAlias;
}
