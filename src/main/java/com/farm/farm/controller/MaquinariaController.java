package com.farm.farm.controller;

@Controller
public class MaquinariaController {

    // Listar todas las maquinarias
    @GetMapping("/maquinaria/listado")
    public String listarTodos(Model model) {
        return "mantenimiento";
    }

    // Añadir nueva maquinaria
    @GetMapping("/maquinaria/nuevo")
    public String addMaquinaria(Model model) {
        return "mantenimiento";
    }

    @GetMapping("/maquinaria/estado")
    public String estadoMaquinaria(Model model) {
        return "mantenimiento";
    }


}
