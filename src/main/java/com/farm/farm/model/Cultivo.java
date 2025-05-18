package com.farm.farm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
// TO DO: @Inheritance(strategy = InheritanceType.JOINED)
public abstract class Cultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String temporada;
    private double superficieHectareas;

}
