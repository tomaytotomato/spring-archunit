package com.tomaytotomato.onion;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "com.tomaytotomato.onion")
public class OnionArchitectureTest {

  @ArchTest
  static final ArchRule onionArchitectureIsRespected = onionArchitecture()
      .domainModels("..domain.model..")
      .domainServices("..domain.service..")
      .applicationServices("..application..")
      .adapter("infra", "..infra..");
}
