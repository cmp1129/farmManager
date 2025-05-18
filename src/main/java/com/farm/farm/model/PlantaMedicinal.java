package com.farm.farm.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PlantaMedicinal extends Cultivo {

    private String propiedadesMedicinales;
    private String formaRecoleccion;

}
