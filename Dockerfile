FROM openjdk:8-alpine3.7
ADD spring/target/Function.jar Function.jar
ENTRYPOINT ["java", "-jar", "Function.jar"]