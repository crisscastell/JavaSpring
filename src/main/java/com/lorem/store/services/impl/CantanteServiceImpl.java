package com.lorem.store.services.impl;


import com.lorem.store.domain.entities.CantanteEntity;
import com.lorem.store.repositories.CantanteRepository;
import com.lorem.store.services.CantanteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CantanteServiceImpl implements CantanteService {
    private final CantanteRepository cantanteRepository;

    public CantanteServiceImpl(CantanteRepository cantanteRepository) {
        this.cantanteRepository = cantanteRepository;
    }

    @Override
    public CantanteEntity crearCantante(CantanteEntity cantanteEntity) {
        return cantanteRepository.save(cantanteEntity);
    }

    @Override
    public CantanteEntity obtenerCantante(Long id) {
        return cantanteRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cantante no encontrado con ID: " + id));
    }

    @Override
    public List<CantanteEntity> obtenerTodosCantantes() {
        return (List<CantanteEntity>) cantanteRepository.findAll();
    }

    @Override
    public void eliminarCantante(Long id) {
        cantanteRepository.deleteById(id);
    }

    @Override
    public CantanteEntity actualizarCantante(CantanteEntity cantanteEntity) {
        return cantanteRepository.save(cantanteEntity);
    }
}
