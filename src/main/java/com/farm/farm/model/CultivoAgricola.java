package com.farm.farm.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CultivoAgricola extends Cultivo {

    private String tipoSuelo;
    private String fertilizanteRecomendado;
}
