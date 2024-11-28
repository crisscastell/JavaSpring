package com.lorem.store.services;

import com.lorem.store.domain.entities.CantanteEntity;

import java.util.List;

public interface CantanteService {
    CantanteEntity crearCantante(CantanteEntity cantanteEntity);
    CantanteEntity obtenerCantante(Long id);
    List<CantanteEntity> obtenerTodosCantantes();
    void eliminarCantante(Long id);
    CantanteEntity actualizarCantante(CantanteEntity cantanteEntity);
}

