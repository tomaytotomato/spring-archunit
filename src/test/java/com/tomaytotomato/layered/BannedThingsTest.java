package com.tomaytotomato.layered;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.GeneralCodingRules.*;

@AnalyzeClasses(packages = "com.tomaytotomato.layered")
public class BannedThingsTest {

  @ArchTest
  private final ArchRule noSTDIO = NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS
      .because("One does not simply output to STD:OUT");

  @ArchTest
  private final ArchRule noGenericExceptions = NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS;

  @ArchTest
  private final ArchRule noJavaUtilLogs = NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING
      .because("That is very naughty and you should be using a facade.");


  @ArchTest
  private final ArchRule noJodaTime = NO_CLASSES_SHOULD_USE_JODATIME
      .because("We aren't using Java 8 lol");


}
