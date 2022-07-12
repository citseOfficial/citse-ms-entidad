package com.entidad.citse.entity;

import com.entidad.citse.models.Tipo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "TMA_ENTIDADES")
public class Entidad implements Serializable {

    @Id
    @Column(name = "ID_ENTIDAD")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NO_ENTIDAD")
    private String nombre;

    @Column(name = "CO_ALIAS")
    private String alias;

    @Column(name = "FE_INSTANCIA")
    private String feInstancia;

    @ManyToOne
    @JoinColumn(name = "ID_PADRE",referencedColumnName = "ID_ENTIDAD")
    private Entidad idPadre;

    @Column(name = "ID_TIPO_ENTIDAD")
    private Integer idTipoEntidad;

    @Transient
    private Tipo tipoEntidad;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "entidad")
    private List<PersonaEntidad> personaEntidades;

}
