package com.farm.farm.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

// TO DO: (Cada clase (padre e hijas) tiene su propia tabla. más limpio, aunque
// requiere JOIN en las consultas.)
// @Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_cultivo", discriminatorType = DiscriminatorType.STRING)
public abstract class Cultivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String temporada;
    private double superficieHectareas;

    // Constructor
    public Cultivo() {
    }

    public Cultivo(Long id, String nombre, String temporada, double superficieHectareas) {
        this.id = id;
        this.nombre = nombre;
        this.temporada = temporada;
        this.superficieHectareas = superficieHectareas;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }

    public double getSuperficieHectareas() {
        return superficieHectareas;
    }

    public void setSuperficieHectareas(double superficieHectareas) {
        this.superficieHectareas = superficieHectareas;
    }

}
