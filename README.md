ArchUnit
---

https://www.archunit.org/

ArchUnit allows developers and principal devs to shape and test the architecture
of a Java application.

In this repo there are some rudimentary and more complicated tests to show ArchUnit
working with a Spring Boot service.

1. Examples for Spring Boot controllers
2. General Architecture tests
3. Extras (Onion, Layered Architecture, Restricting Java package use)


## Conclusion

### ArchUnit is very powerful

You can make very granular or very broad tests for a service

It integrates nicely with JUNIT 5 so there is a low barrier to integrate and
the testing DSL is easy to read.

### ArchUnit should be gentle enforcement

You don't want to use it to shut down any suggestions for change. 

It should be a guide rail to prevent devs from making mistakes or complicating 
architecture.

Some people like DTOs, some people like Records. 

Some people are ogres who like onions, with lots of layers. Others are more flat in 
their world view.

