package com.tomaytotomato.layered.data.entity;

public class Foo {

  Integer id;
  String name;
  String random;

  public Foo() {}

  public Foo(Integer id, String name, String random) {
    this.id = id;
    this.name = name;
    this.random = random;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRandom() {
    return random;
  }

  public void setRandom(String random) {
    this.random = random;
  }
}
