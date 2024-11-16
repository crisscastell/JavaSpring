package com.lorem.store.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class GeneroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genero_id_seq")
    private Long id;

    private String name;


}
