package com.lorem.store.controllers;

import com.lorem.store.domain.dto.CancionDto;
import com.lorem.store.domain.dto.GeneroDto;
import com.lorem.store.domain.entities.CancionEntity;
import com.lorem.store.domain.entities.GeneroEntity;
import com.lorem.store.mappers.impl.CancionMapper;
import com.lorem.store.services.CancionService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log
@RequestMapping("/api/canciones")
public class CancionController {

    private final CancionService cancionService;
    private final CancionMapper cancionMapper;

    public CancionController(CancionService cancionService, CancionMapper cancionMapper) {
        this.cancionService = cancionService;
        this.cancionMapper = cancionMapper;
    }

    @PostMapping
    public CancionDto crearCancion(@RequestBody CancionDto cancionDto) {
        CancionEntity cancionEntity = cancionMapper.mapFrom(cancionDto);
        CancionEntity cancionCreada = cancionService.crearCancion(cancionEntity);
        return cancionMapper.mapTo(cancionCreada);
    }

    @GetMapping("/{id}")
    public CancionDto obtenerCancion(@PathVariable Long id) {
        CancionEntity cancionEntity = cancionService.obtenerCancion(id);
        return cancionMapper.mapTo(cancionEntity);
    }

    @GetMapping
    public List<CancionDto> obtenerTodasCanciones() {
        List<CancionEntity> canciones = cancionService.obtenerTodasCanciones();
        return canciones.stream()
                .map(cancionMapper::mapTo)
                .toList();
    }

    @PutMapping("/{id}")
    public CancionDto actualizarCancion(@PathVariable Long id, @RequestBody CancionDto cancionDto) {
        CancionEntity cancionEntity = cancionMapper.mapFrom(cancionDto);
        cancionEntity.setId(id);
        CancionEntity cancionActualizada = cancionService.actualizarCancion(cancionEntity);
        return cancionMapper.mapTo(cancionActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarCancion(@PathVariable Long id) {
        cancionService.eliminarCancion(id);
    }
}
