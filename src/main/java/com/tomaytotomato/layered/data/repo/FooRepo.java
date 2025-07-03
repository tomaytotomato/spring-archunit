package com.tomaytotomato.layered.data.repo;

import com.tomaytotomato.layered.data.entity.Foo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepo extends CrudRepository<Foo, Integer> {
}
