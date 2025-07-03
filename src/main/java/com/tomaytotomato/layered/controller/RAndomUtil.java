package com.tomaytotomato.layered.controller;

import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.UUID;

@Component
public class RAndomUtil {

  private String seed = "foobar-" + ZonedDateTime.now();

  public String randomString() {
    return UUID.randomUUID().toString().substring(0, 5) + Math.random() + "_" + seed;
  }

}
