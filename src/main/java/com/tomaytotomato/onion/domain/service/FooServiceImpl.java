package com.tomaytotomato.onion.domain.service;

import com.tomaytotomato.onion.domain.model.Foo;
import com.tomaytotomato.onion.domain.service.usecase.CreateFoo;
import com.tomaytotomato.onion.domain.service.usecase.GetFoo;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements GetFoo, CreateFoo {

  private final GetFoo repository;

  public FooServiceImpl(GetFoo fooRepository) {this.repository = fooRepository;}

  @Override
  public Foo getFoo(Integer id) {
    return repository.getFoo(id);
  }

}
