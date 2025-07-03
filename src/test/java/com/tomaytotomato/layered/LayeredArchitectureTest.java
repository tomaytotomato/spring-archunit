package com.tomaytotomato.layered;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.library.Architectures;

/**
 * For a standard MVC style service
 */
@AnalyzeClasses(packages = "com.tomaytotomato.layered")
public class LayeredArchitectureTest {

  @ArchTest
  static final Architectures.LayeredArchitecture architectureShouldFollowPackageLayers = Architectures.layeredArchitecture()
      .consideringAllDependencies()
      .layer("Presentation").definedBy("..controller..")
      .layer("Service").definedBy("..service..")
      .layer("Data").definedBy("..data..")
      .whereLayer("Presentation").mayNotBeAccessedByAnyLayer()
      .whereLayer("Service").mayOnlyBeAccessedByLayers("Presentation")
      .whereLayer("Data").mayOnlyBeAccessedByLayers("Service");
}
