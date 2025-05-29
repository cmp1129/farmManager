package com.farm.farm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EconomiaController {

    @GetMapping("/economia/listado")
    public String listarTodos(Model model) {
        return "mantenimiento";
    }

    @GetMapping("/economia/ganancias/nueva")
    public String addGanancia(Model model) {
        return "mantenimiento";
    }

    @GetMapping("/economia/perdidas/nueva")
    public String addPerdida(Model model) {
        return "mantenimiento";
    }

    @GetMapping("/economia/reportes")
    public String economiaReportes(Model model) {
        return "mantenimiento";
    }

}
