package com.lorem.store.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cantantes")
public class CantanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cantante_id_seq")
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "cantante")
    private Set<CancionEntity> canciones = new HashSet<>();

}
