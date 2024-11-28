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
@Table(name = "generos")
public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genero_id_seq")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "genero")
    private Set<CancionEntity> canciones = new HashSet<>();


}
