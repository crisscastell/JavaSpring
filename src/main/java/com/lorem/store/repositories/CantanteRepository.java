package com.lorem.store.repositories;

import com.lorem.store.domain.entities.CantanteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CantanteRepository extends CrudRepository<CantanteEntity, Long> {
}
