package com.lorem.store.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cancion")
public class CancionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cancion_id_seq")
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id")
    private GeneroEntity genero;

}
