package com.lorem.store.services.impl;

import com.lorem.store.domain.entities.GeneroEntity;
import com.lorem.store.domain.entities.CancionEntity;
import com.lorem.store.repositories.GeneroRepository;
import com.lorem.store.repositories.CancionRepository;
import com.lorem.store.services.CancionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class CancionServiceImpl implements CancionService {
    private CancionRepository cancionRepository;
    private GeneroRepository generoRepository;

    public CancionServiceImpl(CancionRepository cancionRepository, GeneroRepository generoRepository) {
        this.cancionRepository = cancionRepository;
        this.generoRepository = generoRepository;
    }

    @Override
    public CancionEntity crearCancion(CancionEntity cancionEntity) {
        GeneroEntity generoId = cancionEntity.getGenero();
        generoId = generoRepository.findById(generoId.getId()).orElse(null);
        if (generoId == null){
            log.severe("genero not found");
            return null;
        }
        cancionEntity.setGenero(generoId);
        return cancionRepository.save(cancionEntity);
    }

    @Override
    public CancionEntity obtenerCancion(Long id) {
        return cancionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cancion no encontrada con ID: " + id));
    }

    @Override
    public List<CancionEntity> obtenerTodasCanciones() {
        return (List<CancionEntity>) cancionRepository.findAll();
    }

    @Override
    public CancionEntity actualizarCancion(CancionEntity cancionEntity) {
        return cancionRepository.save(cancionEntity);
    }

    @DeleteMapping("/{id}")
    public void eliminarCancion( Long id) {
        cancionRepository.deleteById(id);
    }

}
