package com.farm.farm.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum Ubicacion {
        ESTABLO,
        PASTO,
        CORRAL,
        GRANERO,
        OTRO
    }

    public enum Sexo {
        MACHO,
        HEMBRA
    }

    private String nombre;
    private String especie;
    private int edad;
    private double peso;
    private LocalDate fechaNacimiento;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    private String raza;
    private String estadoSalud;
    private LocalDate fechaUltimaVacuna;
    private String tipoAlimento;
    private String observaciones;
    private boolean embarazada;
    @Enumerated(EnumType.STRING)
    private Ubicacion ubicacion;
    private String emoji;

    // Constructor
    public Animal() {
    }

    public Animal(Long id, String nombre, String especie, int edad, int peso, LocalDate fechaNacimiento, Sexo sexo,
            String raza, String estadoSalud, LocalDate fechaUltimaVacuna, String tipoAlimento, String observaciones,
            boolean embarazada, Ubicacion ubicacion, String emoji) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
        this.peso = peso;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.raza = raza;
        this.estadoSalud = estadoSalud;
        this.fechaUltimaVacuna = fechaUltimaVacuna;
        this.tipoAlimento = tipoAlimento;
        this.observaciones = observaciones;
        this.embarazada = embarazada;
        this.ubicacion = ubicacion;
        this.emoji = emoji;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEstadoSalud() {
        return estadoSalud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estadoSalud = estadoSalud;
    }

    public LocalDate getFechaUltimaVacuna() {
        return fechaUltimaVacuna;
    }

    public void setFechaUltimaVacuna(LocalDate fechaUltimaVacuna) {
        this.fechaUltimaVacuna = fechaUltimaVacuna;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isEmbarazada() {
        return embarazada;
    }

    public void setEmbarazada(boolean embarazada) {
        this.embarazada = embarazada;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especie='" + especie + '\'' +
                ", edad=" + edad + '\'' +
                ", peso=" + peso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Animal))
            return false;
        Animal animal = (Animal) o;
        return edad == animal.edad &&
                Objects.equals(id, animal.id) &&
                Objects.equals(nombre, animal.nombre) &&
                Objects.equals(especie, animal.especie) &&
                Objects.equals(peso, animal.peso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, especie, edad, peso);
    }

}
