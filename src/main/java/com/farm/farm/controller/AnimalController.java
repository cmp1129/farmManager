package com.farm.farm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.farm.farm.model.Animal;
import com.farm.farm.service.AnimalService;

@Controller
public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/animales")
    public String verAnimales(Model model) {
        List<Animal> lista = animalService.listarTodos();
        model.addAttribute("listaAnimales", lista);
        return "plantillaAnimales";
    }

    @GetMapping("/animales/especie/{especie}")
    public String verAnimalesPorEspecie(@PathVariable String especie, Model model) {
        List<Animal> lista = animalService.buscarPorEspecie(especie);
        model.addAttribute("listaAnimales", lista);
        return "plantillaAnimales";
    }

}
