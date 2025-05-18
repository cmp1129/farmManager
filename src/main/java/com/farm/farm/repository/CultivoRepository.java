package com.farm.farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farm.farm.model.Cultivo;

public interface CultivoRepository extends JpaRepository<Cultivo, Long> {
}
