package com.farm.farm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.farm.model.Animal;
import com.farm.farm.service.AnimalService;

@Controller
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    // Listar todos los animales
    @GetMapping("/animales/listado")
    public String verAnimales(Model model) {
        List<Animal> lista = animalService.listarTodos();
        List<String> ubicaciones = animalService.listarUbicaciones();
        model.addAttribute("listaAnimales", lista);
        model.addAttribute("ubicaciones", ubicaciones);
        return "plantillaAnimales";
    }

    @PostMapping("/animales/actualizar/{id}")
    public String actualizarAnimal(@PathVariable Long id,
            @RequestParam String ubicacion,
            @RequestParam String observaciones,
            @RequestParam double peso,
            @RequestParam int edad) {
        Animal animal = animalService.findById(id);
        // Convertir String a enum Ubicacion
        Animal.Ubicacion nuevaUbicacion = Animal.Ubicacion.valueOf(ubicacion.toUpperCase());
        animal.setUbicacion(nuevaUbicacion);
        animal.setObservaciones(observaciones);
        animal.setPeso(peso);
        animal.setEdad(edad);
        animalService.guardar(animal);
        return "redirect:/animales/listado";
    }

    @GetMapping("/animales/especie/{especie}")
    public String verAnimalesPorEspecie(@PathVariable String especie, Model model) {
        List<Animal> lista = animalService.buscarPorEspecie(especie);
        List<String> ubicaciones = animalService.listarUbicaciones();
        model.addAttribute("listaAnimales", lista);
        model.addAttribute("ubicaciones", ubicaciones);
        return "plantillaAnimales";
    }

    @PostMapping("/animales/eliminar/{id}")
    public String eliminarAnimal(@PathVariable Long id) {
        animalService.eliminar(id);
        return "redirect:/animales/listado";
    }

}
