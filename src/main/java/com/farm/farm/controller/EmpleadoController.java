package com.farm.farm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadoController {

    @GetMapping("/empleados/listado")
    public String listarTodos(Model model) {
        return "mantenimiento";
    }

    @GetMapping("/empleados/nuevo")
    public String addEmpleado(Model model) {
        return "mantenimiento";
    }

    @GetMapping("/empleados/reportes")
    public String empleadoReporte(Model model) {
        return "mantenimiento";
    }

}