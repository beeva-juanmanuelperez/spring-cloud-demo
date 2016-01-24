# spring-cloud-demo

This is a proof of concept for Spring Cloud. Covered features:

- Config Server
- Eureka
- Zuul
- Ribbon
- Sidecar

## Used languages and tools

- Java 1.7
- Maven
- Spring Boot

## How do I execute this demo?

The project has several maven modules. Each of one is configured to generate an autoexecutable .jar (through spring-boot-maven plugin), that you can run in 3 different ways:

- Using your favorite IDE. Depending on the IDE, you will have to follow different steps (just google it :)

- Using java (command line) [Recommended]. If your computer doesn't have lots of memory, consider to restrict memory usage for every microservice, as follows.
```bash
java -jar <name>.jar -Xmx128m -Xms128m
```

- Using maven (command line), inside the module directory
```bash
mvn spring-boot:run
```
