package com.lorem.store.controllers;

import com.lorem.store.domain.dto.CancionDto;
import com.lorem.store.domain.entities.CancionEntity;
import com.lorem.store.mappers.impl.CancionMapper;
import com.lorem.store.services.CancionService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class CancionController {

    private final CancionService cancionService;
    private final CancionMapper cancionMapper;

    public CancionController(CancionService cancionService, CancionMapper cancionMapper) {
        this.cancionService = cancionService;
        this.cancionMapper = cancionMapper;
    }

    @PostMapping("/api/canciones")
    public CancionDto createCancion(@RequestBody CancionDto cancionDto) {
        CancionEntity cancionEntity = cancionMapper.mapFrom(cancionDto);
        CancionEntity createdCancionEntity = cancionService.createCancion(cancionEntity);
        return cancionMapper.mapTo(createdCancionEntity);
    }
}
