package com.lorem.store.mappers.impl;

import com.lorem.store.domain.dto.GeneroDto;
import com.lorem.store.domain.entities.GeneroEntity;
import com.lorem.store.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class GeneroMapper implements Mapper<GeneroEntity, GeneroDto> {

    private ModelMapper modelMapper;

    public GeneroMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public GeneroDto mapTo(GeneroEntity generoEntity) {
        return modelMapper.map(generoEntity, GeneroDto.class);
    }

    @Override
    public GeneroEntity mapFrom(GeneroDto generoDto) {
        return modelMapper.map(generoDto, GeneroEntity.class);
    }
}
