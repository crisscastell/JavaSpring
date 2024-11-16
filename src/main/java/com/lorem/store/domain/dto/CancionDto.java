package com.lorem.store.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancionDto {
    private Long id;

    private String name;

    private GeneroDto genero;
}
