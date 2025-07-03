package com.tomaytotomato.dto;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "com.tomaytotomato.dto")
public class IDontLikeDTOTest {

  @ArchTest
  static final ArchRule noDTOSuffix =
      noClasses()
          .should().haveSimpleNameEndingWith("DTO");


  @ArchTest
  static final ArchRule useRecordsInsteadOfMutableClasses =
      classes()
          .that().areNotEnums()
          .and().areNotInterfaces()
          .and().areNotAnnotations()
          .and().areNotAnnotatedWith(Entity.class)
          .and().areNotAnnotatedWith(Service.class)
          .and().areNotAnnotatedWith(Component.class)
          .and().areNotAnnotatedWith(Controller.class)
          .and().areNotAnnotatedWith(RestController.class)
          .and().areNotAnnotatedWith(Repository.class)
          .should().beRecords()
          .as("Data classes should be records");

  @ArchTest
  static final ArchRule recordsShouldBeImmutable =
      fields()
          .that().areDeclaredInClassesThat().areRecords()
          .and().areNotStatic()
          .should().beFinal()
          .as("Record fields should be final (immutable)");


}
