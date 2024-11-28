package com.lorem.store.controllers;

import com.lorem.store.domain.dto.GeneroDto;
import com.lorem.store.domain.entities.GeneroEntity;
import com.lorem.store.mappers.impl.GeneroMapper;
import com.lorem.store.services.GeneroService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Log
@RequestMapping("/api/genero")
public class GeneroController {

    private final GeneroService generoService;
    private final GeneroMapper generoMapper;

    public GeneroController(GeneroService generoService, GeneroMapper generoMapper) {
        this.generoService = generoService;
        this.generoMapper = generoMapper;
    }

    @PostMapping
    public GeneroDto crearGenero(@RequestBody GeneroDto generoDto) {
        GeneroEntity generoEntity = generoMapper.mapFrom(generoDto);
        GeneroEntity generoCreado = generoService.crearGenero(generoEntity);
        return generoMapper.mapTo(generoCreado);
    }

    @GetMapping("/{id}")
    public GeneroDto obtenerGenero(@PathVariable Long id) {
        GeneroEntity generoEntity = generoService.obtenerGenero(id);
        return generoMapper.mapTo(generoEntity);
    }

    @GetMapping
    public List<GeneroDto> obtenerTodosGeneros() {
        List<GeneroEntity> generos = generoService.obtenerTodosGeneros();
        return generos.stream()
                .map(generoMapper::mapTo)
                .toList();
    }

    @PutMapping("/{id}")
    public GeneroDto actualizarGenero(@PathVariable Long id, @RequestBody GeneroDto generoDto) {
        GeneroEntity generoEntity = generoMapper.mapFrom(generoDto);
        generoEntity.setId(id);
        GeneroEntity generoActualizado = generoService.actualizarGenero(generoEntity);
        return generoMapper.mapTo(generoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarGenero(@PathVariable Long id) {
        generoService.deleteGenero(id);
    }
}
