package com.farm.farm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.farm.farm.model.Animal;
import com.farm.farm.repository.AnimalRepository;

@Service
public class AnimalService {
    // Centralizar la lógica de negocio
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Animal no encontrado con id: " + id));
    }

    public void deleteById(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> listarTodos() {
        return animalRepository.findAll();
    }

    public void guardar(Animal animal) {
        animalRepository.save(animal);
    }

    public void eliminar(Long id) {
        animalRepository.deleteById(id);
    }

    public List<Animal> buscarPorEspecie(String especie) {
        return animalRepository.findByEspecie(especie);
    }

    public List<String> listarUbicaciones() {
        return animalRepository.findDistinctUbicaciones();
    }

}
