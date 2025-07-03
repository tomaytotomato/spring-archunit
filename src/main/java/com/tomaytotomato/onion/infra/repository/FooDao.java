package com.tomaytotomato.onion.infra.repository;

import com.tomaytotomato.onion.infra.entity.FooEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooDao extends CrudRepository<FooEntity, Integer> {
}
