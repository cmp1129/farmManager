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
        return "animales/plantillaAnimales"; // thymeleaf lee de /templates pero esta dentro de la carpeta animales
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
        return "animales/plantillaAnimales"; // thymeleaf lee de /templates pero esta dentro de la carpeta animales
    }

    @GetMapping("/animales/sexo/{sexo}")
    public String verAnimalesPorSexo(@PathVariable String sexo, Model model) {
        List<Animal> lista = animalService.buscarPorSexo(sexo);
        List<String> ubicaciones = animalService.listarUbicaciones();
        model.addAttribute("listaAnimales", lista);
        model.addAttribute("ubicaciones", ubicaciones);
        return "animales/plantillaAnimales"; // thymeleaf lee de /templates pero esta dentro de la carpeta animales
    }

    @PostMapping("/animales/eliminar/{id}")
    public String eliminarAnimal(@PathVariable Long id) {
        animalService.eliminar(id);
        return "redirect:/animales/listado";
    }

    @PostMapping("/animales/guardar")
    public String guardarAnimal(Animal animal) {
        animalService.guardar(animal);
        return "redirect:/animales/listado";
    }

    @GetMapping("/animales/nuevo")
    public String animalesNuevo(Model model) {
        model.addAttribute("animal", new Animal());
        return "animales/formularioAnimal"; // thymeleaf lee de /templates pero esta dentro de la carpeta animales
    }

    // @GetMapping("/animales/estadisticas")
    // public String animalesEstadisticas(Model model) {
    // model.addAttribute("animal", new Animal());
    // return "animales/chartsAnimals";
    // dentro de la carpeta animales
    // }

    @GetMapping("/animales/estadisticas")
    public String verEstadisticas(Model model) {
        model.addAttribute("totalAnimales", animalService.contarAnimales());
        model.addAttribute("animalesEmbarazados", animalService.contarEmbarazadas());
        model.addAttribute("animalesHeridos", animalService.contarHeridos());
        model.addAttribute("mediaPeso", animalService.calcularMediaPeso());
        model.addAttribute("animalesPorEspecie", animalService.contarAnimalesPorEspecie());
        return "animales/chartsAnimals";
    }

}
