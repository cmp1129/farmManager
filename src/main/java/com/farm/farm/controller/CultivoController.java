package com.farm.farm.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.farm.farm.model.Cultivo;
import com.farm.farm.model.CultivoAgricola;
import com.farm.farm.model.PlantaMedicinal;
import com.farm.farm.service.CultivoService;

@Controller
public class CultivoController {

    private final CultivoService cultivoService;

    public CultivoController(CultivoService cultivoService) {
        this.cultivoService = cultivoService;
    }

    // Listar todos los cultivos
    @GetMapping("/cultivos/listado")
    public String listarTodos(Model model) {
        List<Cultivo> cultivos = cultivoService.listarTodos();
        model.addAttribute("cultivos", cultivos);
        // return "plantillaCultivos"; // aun no esta implementada
        return "mantenimiento";
    }

    @GetMapping("/cultivos/nuevo")
    public String laddCultivos(Model model) {
        return "mantenimiento";
    }

    // Listar solo Plantas Medicinales
    @GetMapping("/plantas-medicinales")
    public String listarPlantasMedicinales(Model model) {
        List<PlantaMedicinal> plantas = cultivoService.listarPlantasMedicinales();
        model.addAttribute("plantasMedicinales", plantas);
        return "plantillaPlantasMedicinales";
    }

    // Listar solo Cultivos Agrícolas
    @GetMapping("/agricolas")
    public String listarCultivosAgricolas(Model model) {
        List<CultivoAgricola> agricolas = cultivoService.listarCultivosAgricolas();
        model.addAttribute("cultivosAgricolas", agricolas);
        return "plantillaCultivosAgricolas";
    }

    // Buscar cultivo por ID
    @GetMapping("/{id}")
    public String obtenerCultivoPorId(@PathVariable Long id, Model model) {
        Cultivo cultivo = cultivoService.buscarPorId(id);
        model.addAttribute("cultivo", cultivo);
        return "detalleCultivo";
    }

    // Buscar cultivos por nombre (contiene)
    @GetMapping("/buscar")
    public String buscarPorNombre(@RequestParam String nombre, Model model) {
        List<Cultivo> cultivos = cultivoService.buscarPorNombre(nombre);
        model.addAttribute("cultivos", cultivos);
        return "plantillaCultivos";
    }

    // Crear nueva Planta Medicinal (formulario)
    @GetMapping("/plantas-medicinales/nuevo")
    public String mostrarFormularioNuevaPlanta(Model model) {
        model.addAttribute("plantaMedicinal", new PlantaMedicinal());
        return "formPlantaMedicinal";
    }

    // Guardar nueva Planta Medicinal
    @PostMapping("/plantas-medicinales")
    public String crearPlantaMedicinal(@ModelAttribute PlantaMedicinal planta) {
        cultivoService.guardarPlantaMedicinal(planta);
        return "redirect:/cultivos/plantas-medicinales";
    }

    // Crear nuevo Cultivo Agrícola (formulario)
    @GetMapping("/agricolas/nuevo")
    public String mostrarFormularioNuevoAgricola(Model model) {
        model.addAttribute("cultivoAgricola", new CultivoAgricola());
        return "formCultivoAgricola";
    }

    // Guardar nuevo Cultivo Agrícola
    @PostMapping("/agricolas")
    public String crearCultivoAgricola(@ModelAttribute CultivoAgricola cultivo) {
        cultivoService.guardarCultivoAgricola(cultivo);
        return "redirect:/cultivos/agricolas";
    }

    // Eliminar cultivo por ID
    @PostMapping("/{id}/eliminar")
    public String eliminarCultivo(@PathVariable Long id) {
        cultivoService.eliminarCultivo(id);
        return "redirect:/cultivos";
    }

}
