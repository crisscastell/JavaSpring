package com.lorem.store.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancionDto {
    private Long id;

    private String name;

    private GeneroDto genero;
    private Set<CantanteDto> cantantes;
}
