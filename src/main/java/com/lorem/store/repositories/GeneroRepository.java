package com.lorem.store.repositories;

import com.lorem.store.domain.entities.GeneroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository extends CrudRepository<GeneroEntity, Long> {
}
