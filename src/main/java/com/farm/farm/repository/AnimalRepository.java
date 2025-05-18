package com.farm.farm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.farm.farm.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // Método que filtra por especie de animal
    List<Animal> findByEspecie(String especie);

    @Query("SELECT DISTINCT a.ubicacion FROM Animal a")
    List<String> findDistinctUbicaciones();

}
