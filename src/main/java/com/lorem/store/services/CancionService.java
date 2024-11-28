package com.lorem.store.services;

import com.lorem.store.domain.entities.CancionEntity;
import com.lorem.store.domain.entities.CantanteEntity;
import com.lorem.store.domain.entities.GeneroEntity;

import java.util.List;
import java.util.Optional;

public interface CancionService {
    CancionEntity crearCancion(CancionEntity cancionEntity);
    CancionEntity obtenerCancion(Long id);
    List<CancionEntity> obtenerTodasCanciones();
    CancionEntity actualizarCancion(CancionEntity cancionEntity);
    void eliminarCancion(Long id);

}
