package com.farm.farm.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

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

    public List<Animal> buscarPorSexo(String sexo) {
        return animalRepository.findBySexo(sexo);
    }

    public List<String> listarUbicaciones() {
        return animalRepository.findDistinctUbicaciones();
    }

    // Contar todos los animales
    public long contarAnimales() {
        return animalRepository.contarAnimales();
    }

    // Contar embarazadas
    public long contarEmbarazadas() {
        return animalRepository.contarEmbarazadas();
    }

    // Contar heridos
    public long contarHeridos() {
        return animalRepository.contarHeridos();
    }

    // Calcular media de peso
    public double calcularMediaPeso() {
        return animalRepository.calcularMediaPeso();
    }

    public Map<String, Long> contarAnimalesPorEspecie() {
        List<Animal> animales = animalRepository.findAll();
        return animales.stream()
                .collect(Collectors.groupingBy(Animal::getEspecie, Collectors.counting()));
    }

}
