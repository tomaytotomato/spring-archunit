package com.tomaytotomato.layered.service;

import java.util.logging.Logger;

public class FooService {

  private static Logger log = Logger.getLogger("FooService");

  public void fubar() {
    System.out.println("Hello World");
    log.info("Hello World");
    throw new RuntimeException("Not implemented");
  }
}
