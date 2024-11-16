package com.lorem.store.services;

import com.lorem.store.domain.entities.CancionEntity;

import java.util.Optional;

public interface CancionService {
    CancionEntity createCancion(CancionEntity cancionEntity);
    Optional<CancionEntity> getCancionById(Long id);
    void deleteCancion(Long id);
    CancionEntity updateCancion(CancionEntity cancionEntity);

}
