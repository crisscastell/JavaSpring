package com.lorem.store.mappers.impl;

import com.lorem.store.domain.dto.CantanteDto;
import com.lorem.store.domain.entities.CancionEntity;
import com.lorem.store.domain.entities.CantanteEntity;
import com.lorem.store.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
public class CantanteMapper  implements Mapper<CantanteEntity, CantanteDto> {

    private final ModelMapper modelMapper;

    public CantanteMapper(ModelMapper modelMapper){
        this.modelMapper=modelMapper;
    }

    @Override
    public CantanteDto mapTo(CantanteEntity cantanteEntity) {
        return modelMapper.map(cantanteEntity, CantanteDto.class);
    }

    @Override
    public CantanteEntity mapFrom(CantanteDto autorDto) {
        return modelMapper.map(autorDto, CantanteEntity.class);
    }
}
