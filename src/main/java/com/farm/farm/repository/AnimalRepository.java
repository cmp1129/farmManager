package com.farm.farm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.farm.farm.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // Filtra por especie de animal
    List<Animal> findByEspecie(String especie);

    // Selecciona todos los valores sin repetir de la columna ubicacion
    @Query("SELECT DISTINCT a.ubicacion FROM Animal a")
    List<String> findDistinctUbicaciones();

    // Filtra por sexo de animal
    List<Animal> findBySexo(String sexo);

    @Query("SELECT COUNT(a) FROM Animal a")
    long contarAnimales();

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.estadoSalud = 'Sano'")
    long contarSanos();

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.estadoSalud = 'Herido'")
    long contarHeridos();

    @Query("SELECT AVG(a.peso) FROM Animal a")
    double calcularMediaPeso();

    @Query("SELECT COUNT(a) FROM Animal a WHERE a.embarazada = true")
    long contarEmbarazadas();

}
