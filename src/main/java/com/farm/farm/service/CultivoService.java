package com.farm.farm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.farm.farm.model.Cultivo;
import com.farm.farm.repository.CultivoRepository;

@Service
public class CultivoService {

    private final CultivoRepository cultivoRepository;

    public CultivoService(CultivoRepository cultivoRepository) {
        this.cultivoRepository = cultivoRepository;
    }

    public List<Cultivo> listarTodos() {
        return cultivoRepository.findAll();
    }

    public void deleteById(Long id) {
        cultivoRepository.deleteById(id);
    }

}
