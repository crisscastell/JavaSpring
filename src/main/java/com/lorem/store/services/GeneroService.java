package com.lorem.store.services;

import com.lorem.store.domain.entities.GeneroEntity;

import java.util.Optional;

public interface GeneroService {
    GeneroEntity createGenero(GeneroEntity generoEntity);
    GeneroEntity readGenero(Long id);
    Optional<GeneroEntity> getGeneroById(Long id);
    Optional<GeneroEntity> updateGenero(Long id, GeneroEntity generoEntity);
    void deleteGenero(Long id);
}
