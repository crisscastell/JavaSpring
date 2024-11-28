package com.lorem.store.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CantanteDto {
    private Long id;
    private String nombre;
    private Set<CancionDto> canciones;
}
