package com.tomaytotomato.layered.controller;

import com.tomaytotomato.layered.data.entity.Foo;
import com.tomaytotomato.layered.data.repo.FooRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooEndpoint {

  private FooRepo fooRepo;

  @GetMapping("/foo/{id}")
  public ResponseEntity<Foo> getFooById(@PathVariable Integer id) {
    return fooRepo.findById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  public void createFoo(Foo foo) {
    fooRepo.save(foo);
  }

}
