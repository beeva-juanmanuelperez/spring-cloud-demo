To execute this project:

1. Compile the project

    mvn clean compile

2. Repackage the JAR file using spring boot maven plugin. This will create a self executable JAR file

    mvn spring-boot:repackage

3. Execute /target/<project>.jar

    java -jar target/<project>.jar



