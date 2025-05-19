package com.farm.farm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.farm.farm.model.Cultivo;
import com.farm.farm.model.CultivoAgricola;
import com.farm.farm.model.PlantaMedicinal;
import com.farm.farm.repository.CultivoRepository;

@Service
public class CultivoService {

    /**
     * Puedes manejar todas las operaciones comunes
     * desde el CultivoService, porque en la estrategia
     * SINGLE_TABLE todo se guarda en una sola tabla, y
     * Hibernate sabe a qué subtipo pertenece cada registro
     * usando una columna discriminadora que crea
     * automáticamente (DTYPE por defecto).
     */
    private final CultivoRepository cultivoRepository;

    public CultivoService(CultivoRepository cultivoRepository) {
        this.cultivoRepository = cultivoRepository;
    }

    public Cultivo buscarPorId(Long id) {
        return cultivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cultivo no encontrado con id: " + id));
    }

    public List<Cultivo> listarTodos() {
        return cultivoRepository.findAll();
    }

    public List<PlantaMedicinal> listarPlantasMedicinales() {
        return cultivoRepository.findAll().stream()
                .filter(c -> c instanceof PlantaMedicinal)
                .map(c -> (PlantaMedicinal) c)
                .toList();
    }

    public List<CultivoAgricola> listarCultivosAgricolas() {
        return cultivoRepository.findAll().stream()
                .filter(c -> c instanceof CultivoAgricola)
                .map(c -> (CultivoAgricola) c)
                .toList();
    }

    public void eliminarCultivo(Long id) {
        if (!cultivoRepository.existsById(id)) {
            throw new RuntimeException("Cultivo no encontrado con id: " + id);
        }
        cultivoRepository.deleteById(id);
    }

    public PlantaMedicinal guardarPlantaMedicinal(PlantaMedicinal planta) {
        return cultivoRepository.save(planta);
    }

    public CultivoAgricola guardarCultivoAgricola(CultivoAgricola cultivo) {
        return cultivoRepository.save(cultivo);
    }

    public List<Cultivo> buscarPorNombre(String nombre) {
        return cultivoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Cultivo actualizarCultivo(Long id, Cultivo cultivoActualizado) {
        Cultivo cultivoExistente = buscarPorId(id);

        cultivoExistente.setNombre(cultivoActualizado.getNombre());
        cultivoExistente.setTemporada(cultivoActualizado.getTemporada());
        cultivoExistente.setSuperficieHectareas(cultivoActualizado.getSuperficieHectareas());

        if (cultivoExistente instanceof PlantaMedicinal plantaExistente
                && cultivoActualizado instanceof PlantaMedicinal plantaActualizada) {
            plantaExistente.setFormaRecoleccion(plantaActualizada.getFormaRecoleccion());
            plantaExistente.setPropiedadesMedicinales(plantaActualizada.getPropiedadesMedicinales());
        }

        if (cultivoExistente instanceof CultivoAgricola agricolaExistente
                && cultivoActualizado instanceof CultivoAgricola agricolaActualizado) {
            agricolaExistente.setFertilizanteRecomendado(agricolaActualizado.getFertilizanteRecomendado());
            agricolaExistente.setTipoSuelo(agricolaActualizado.getTipoSuelo());
        }

        return cultivoRepository.save(cultivoExistente);
    }

}
