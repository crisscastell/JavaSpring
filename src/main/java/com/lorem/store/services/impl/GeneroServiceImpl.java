package com.lorem.store.services.impl;

import com.lorem.store.domain.entities.CantanteEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.repository.CrudRepository.*;
import com.lorem.store.domain.entities.GeneroEntity;
import com.lorem.store.repositories.GeneroRepository;
import com.lorem.store.services.GeneroService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;


import java.util.List;
import java.util.Optional;

@Service
public class GeneroServiceImpl implements  GeneroService {

    private com.lorem.store.repositories.GeneroRepository generoRepository;

    public GeneroServiceImpl(com.lorem.store.repositories.GeneroRepository generoRepository) {

        this.generoRepository = generoRepository;
    }

    @Override
    public GeneroEntity crearGenero(GeneroEntity generoEntity) {
        return generoRepository.save(generoEntity);
    }

    @Override
    public GeneroEntity obtenerGenero(Long id) {
        return generoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Genero no encontrado con ID: " + id));
    }

    @Override
    public List<GeneroEntity> obtenerTodosGeneros() {
        return (List<GeneroEntity>) generoRepository.findAll();
    }

    @Override
    public GeneroEntity actualizarGenero(GeneroEntity generoEntity) {
        return generoRepository.save(generoEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteGenero( Long id) {
        generoRepository.deleteById(id);
    }
}


