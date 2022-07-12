package com.entidad.citse.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class Comunidad {
    private Integer idComunidad;
    private String noComunidad;
    private Integer nuBeneficiarios;
    private Boolean esComunidad;
}
