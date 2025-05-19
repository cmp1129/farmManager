package com.farm.farm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farm.farm.model.Cultivo;

public interface CultivoRepository extends JpaRepository<Cultivo, Long> {

    List<Cultivo> findByNombreContainingIgnoreCase(String nombre);

}
