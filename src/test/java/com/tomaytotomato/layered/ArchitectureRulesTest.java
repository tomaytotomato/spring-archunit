package com.tomaytotomato.layered;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.conditions.ArchConditions;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@AnalyzeClasses(packages = "com.tomaytotomato.layered")
class ArchitectureRulesTest {

  @ArchTest
  static final ArchRule controllersShouldOnlyUseServiceClasses =
      classes()
          .that().resideInAPackage("..controller..")
          .and().areAnnotatedWith(RestController.class)
          .should().dependOnClassesThat().resideInAnyPackage("..service..")
          .andShould().beAnnotatedWith(Service.class);

  @ArchTest
  static final ArchRule controllersShouldNotAccessEntitiesDirectly =
      noClasses()
          .that().areAnnotatedWith(RestController.class)
          .should().dependOnClassesThat().areAnnotatedWith(Entity.class);

  @ArchTest
  static final ArchRule servicesShouldHaveCorrectSpringBeanStereotype =
      classes()
          .that().resideInAPackage("..service..")
          .should().beAnnotatedWith(Service.class)
          .as("Spring bean stereotyping is good practice");

  @ArchTest
  static final ArchRule servicesShouldImplementInterfaces =
      classes()
          .that().resideInAPackage("..service..")
          .and().areAnnotatedWith(Service.class)
          .should(ArchConditions.implement(JavaClass.Predicates.INTERFACES))
          .as("Services should implement interfaces for better testability and loose coupling");

  @ArchTest
  static final ArchRule interfacesShouldntBeSuffixedWithTheWordInterface =
      noClasses().that().areInterfaces()
          .and().resideInAPackage("..service..")
          .should().haveNameMatching(".*Interface");

}