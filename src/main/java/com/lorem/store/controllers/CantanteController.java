package com.lorem.store.controllers;

import com.lorem.store.domain.dto.CantanteDto;
import com.lorem.store.domain.entities.CancionEntity;
import com.lorem.store.domain.entities.CantanteEntity;
import com.lorem.store.mappers.impl.CantanteMapper;
import com.lorem.store.services.CantanteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/cantantes")
public class CantanteController {
    private final CantanteService cantanteService;
    private final CantanteMapper cantanteMapper;

    public CantanteController(CantanteService cantanteService, CantanteMapper cantanteMapper) {
        this.cantanteService = cantanteService;
        this.cantanteMapper = cantanteMapper;
    }

    @PostMapping
    public CantanteDto crearCantante(@RequestBody CantanteDto cantanteDto) {
        CantanteEntity cantanteEntity = cantanteMapper.mapFrom(cantanteDto);
        CantanteEntity cantanteCreado = cantanteService.crearCantante(cantanteEntity);
        return cantanteMapper.mapTo(cantanteCreado);
    }

    @GetMapping("/{id}")
    public CantanteDto obtenerCantante(@PathVariable Long id) {
        CantanteEntity cantanteEntity = cantanteService.obtenerCantante(id);
        return cantanteMapper.mapTo(cantanteEntity);
    }

    @GetMapping
    public List<CantanteDto> obtenerTodosCantantes() {
        List<CantanteEntity> cantantes = cantanteService.obtenerTodosCantantes();
        return cantantes.stream()
                .map(cantanteMapper::mapTo)
                .toList();
    }

    @PutMapping("/{id}")
    public CantanteDto actualizarCantante(@PathVariable Long id, @RequestBody CantanteDto cantanteDto) {
        CantanteEntity cantanteEntity = cantanteMapper.mapFrom(cantanteDto);
        cantanteEntity.setId(id);
        CantanteEntity autorActualizado = cantanteService.actualizarCantante(cantanteEntity);
        return cantanteMapper.mapTo(autorActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarCantante(@PathVariable Long id) {
        cantanteService.eliminarCantante(id);
    }
}
