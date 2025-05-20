package com.farm.farm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToHomePage() {
        return "homePage";
    }

    @GetMapping("/animales")
    public String homeAnimales() {
        return "homeAnimales";
    }

    @GetMapping("/cultivos")
    public String homeCultivos() {
        return "homeCultivos";
    }

    @GetMapping("/maquinaria")
    public String homeMaquinaria() {
        return "homeMaquinaria";
    }

    @GetMapping("/economia")
    public String homeEconomia() {
        return "homeEconomia";
    }

    @GetMapping("/empleados")
    public String homeEmpleados() {
        return "homeEmpleados";
    }

}
