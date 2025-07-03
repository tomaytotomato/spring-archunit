package com.tomaytotomato.onion.application.controller;

import com.tomaytotomato.onion.domain.model.Foo;
import com.tomaytotomato.onion.domain.service.usecase.GetFoo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {

  private final GetFoo fooService;

  public FooController(GetFoo fooService) {this.fooService = fooService;}

  @GetMapping(path = "/foo/{id}")
  public Foo getFoo(@PathVariable Integer id) {
    return fooService.getFoo(id);
  }

}
