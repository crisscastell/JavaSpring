package com.lorem.store.repositories;

import com.lorem.store.domain.entities.CancionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancionRepository extends CrudRepository<CancionEntity, Long> {
}
