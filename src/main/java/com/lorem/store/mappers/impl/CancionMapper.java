package com.lorem.store.mappers.impl;

import com.lorem.store.domain.dto.CancionDto;
import com.lorem.store.domain.entities.CancionEntity;
import com.lorem.store.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CancionMapper implements Mapper<CancionEntity, CancionDto> {
    private ModelMapper modelMapper;

    public CancionMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CancionDto mapTo(CancionEntity cancionEntity) {
        return modelMapper.map(cancionEntity, CancionDto.class);
    }

    @Override
    public CancionEntity mapFrom(CancionDto cancionDto) {
        return modelMapper.map(cancionDto, CancionEntity.class);
    }
}
