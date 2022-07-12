package com.entidad.citse.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Transient;

@Data
@Builder
public class Persona {

    private Integer idPersona;
    private String noPersona;
    private String apPaterno;
    private String apMaterno;
    private String nuIndentificacion;
    private String feNacimiento;
    private Boolean esPersona;
    private Tipo tipoIdentificacion;
    private Tipo tipoPersona;
    private Tipo esCivil;

}
