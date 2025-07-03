package com.tomaytotomato.onion.infra.repository;

import com.tomaytotomato.onion.domain.model.Foo;
import com.tomaytotomato.onion.domain.service.usecase.CreateFoo;
import com.tomaytotomato.onion.domain.service.usecase.GetFoo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FooRepository implements GetFoo, CreateFoo {

  private final FooDao fooDao;

  @Autowired
  public FooRepository(FooDao fooDao) {this.fooDao = fooDao;}

  @Override
  public Foo getFoo(Integer id) {
    return fooDao.findById(id).map(fooEntity -> new Foo(fooEntity.getId(), fooEntity.getName()))
        .orElseThrow(() -> new EntityNotFoundException("Foo with id " + id + " not found"));
  }
}
