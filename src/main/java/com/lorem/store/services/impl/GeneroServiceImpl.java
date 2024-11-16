package com.lorem.store.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.repository.CrudRepository.*;
import com.lorem.store.domain.entities.GeneroEntity;
import com.lorem.store.repositories.GeneroRepository;
import com.lorem.store.services.GeneroService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;



import java.util.Optional;

@Service
public class GeneroServiceImpl implements  GeneroService {

    private com.lorem.store.repositories.GeneroRepository generoRepository;

    public GeneroServiceImpl(com.lorem.store.repositories.GeneroRepository generoRepository) {

        this.generoRepository = generoRepository;
    }

    @Override
    public GeneroEntity createGenero(GeneroEntity generoEntity) {
        return generoRepository.save(generoEntity);
    }

    @Override
    public Optional<GeneroEntity> getGeneroById(Long id) {
        return Optional.empty();
    }

    @Override
    public GeneroEntity readGenero(Long id) {
        return generoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Genero no encontrado con ID: " + id));
    }

    @Override
    public Optional<GeneroEntity> updateGenero(Long id, GeneroEntity generoEntity) {
        Optional<GeneroEntity> generoExistente = getGeneroById(id);
        if(generoExistente.isPresent()){
            GeneroEntity genero = generoExistente.get();
            genero.setName(generoEntity.getName());
            return Optional.of(generoRepository.save(genero));
       } else {
            return Optional.empty();
        }
    }

    @DeleteMapping("/{id}") public void deleteGenero( Long id) { generoRepository.deleteById(id); }
}


