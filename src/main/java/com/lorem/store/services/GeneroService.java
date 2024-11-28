package com.lorem.store.services;

import com.lorem.store.domain.entities.CancionEntity;
import com.lorem.store.domain.entities.CantanteEntity;
import com.lorem.store.domain.entities.GeneroEntity;

import java.util.List;
import java.util.Optional;

public interface GeneroService {
    GeneroEntity crearGenero(GeneroEntity generoEntity);
    GeneroEntity obtenerGenero(Long id);
    List<GeneroEntity> obtenerTodosGeneros();
    GeneroEntity actualizarGenero(GeneroEntity generoEntity);
    void deleteGenero(Long id);
}
