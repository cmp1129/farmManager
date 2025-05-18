package com.farm.farm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farm.farm.model.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    // Método que filtra por especie de animal
    List<Animal> findByEspecie(String especie);
}
