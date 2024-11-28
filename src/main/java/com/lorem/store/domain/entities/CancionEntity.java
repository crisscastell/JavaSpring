package com.lorem.store.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "canciones")
public class CancionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancion_id_seq")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "canciones-cantantes",
            joinColumns = @JoinColumn(name = "cancion_id"),
            inverseJoinColumns = @JoinColumn(name = "cantante_id")
    )
    private Set<CantanteEntity> cantante = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;


}
