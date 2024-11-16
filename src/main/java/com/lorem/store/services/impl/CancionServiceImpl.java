package com.lorem.store.services.impl;

import com.lorem.store.domain.entities.GeneroEntity;
import com.lorem.store.domain.entities.CancionEntity;
import com.lorem.store.repositories.GeneroRepository;
import com.lorem.store.repositories.CancionRepository;
import com.lorem.store.services.CancionService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

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
    public CancionEntity createCancion(CancionEntity cancionEntity) {
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
    public Optional<CancionEntity> getCancionById(Long id) {
        return cancionRepository.findById(id);
    }

    @Override
    public void deleteCancion(Long id) {
        cancionRepository.deleteById(id);
    }

    @Override
    public CancionEntity updateCancion(CancionEntity cancionEntity) {
        return cancionRepository.save(cancionEntity);
    }


}
