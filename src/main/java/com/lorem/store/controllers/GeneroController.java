package com.lorem.store.controllers;

import com.lorem.store.domain.dto.GeneroDto;
import com.lorem.store.domain.entities.GeneroEntity;
import com.lorem.store.mappers.impl.GeneroMapper;
import com.lorem.store.services.GeneroService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class GeneroController {

    private GeneroService generoRepository;

    private GeneroMapper generoMapper;

    public GeneroController(GeneroService generoRepository, GeneroMapper generoMapper) {
        this.generoRepository = generoRepository;
        this.generoMapper = generoMapper;
    }

    @GetMapping("/api/generos")
    public GeneroDto retrieveCategory() {
        return new GeneroDto();
    }

    @PostMapping("/api/generos")
    public GeneroDto createGenero(@RequestBody final GeneroDto generoDto){
        GeneroEntity generoEntity = generoMapper.mapFrom(generoDto);
        GeneroEntity createdCategory = generoRepository.createCategory(generoEntity);
        return generoMapper.mapTo(createdCategory);
    }
}
