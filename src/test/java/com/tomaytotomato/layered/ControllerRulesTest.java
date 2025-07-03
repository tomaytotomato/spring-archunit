package com.tomaytotomato.layered;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "com.tomaytotomato.layered")
class ControllerRulesTest {

  @ArchTest
  static final ArchRule noControllerAnnotationsShouldBeUsed =
      noClasses()
          .should().beAnnotatedWith(Controller.class);

  @ArchTest
  static final ArchRule controllerClassesShouldOnlyBeInTheControllerPackage =
      classes()
          .that().areAnnotatedWith(RestController.class)
          .should().resideInAPackage("..controller..");

  @ArchTest
  static final ArchRule controllerClassesShouldBeSuffixedWithControllerInTheirName =
      classes()
          .that().resideInAPackage("..controller..")
          .should().haveSimpleNameEndingWith("Controller");

  @ArchTest
  static final ArchRule controllerClassesShouldUseSpringRestControllerAnnotation =
      classes()
          .that().haveSimpleNameEndingWith("Controller")
          .should().beAnnotatedWith(RestController.class);

  @ArchTest
  static final ArchRule controllerClassesShouldHaveRequestMappingAnnotationsIfPublic =
      methods()
          .that().areDeclaredInClassesThat().areAnnotatedWith(RestController.class)
          .and().arePublic()
          .should().beAnnotatedWith(RequestMapping.class)
          .orShould().beAnnotatedWith(GetMapping.class)
          .orShould().beAnnotatedWith(PostMapping.class);

}