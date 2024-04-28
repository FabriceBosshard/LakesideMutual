FROM maven:3.8.4-openjdk-17-slim as build

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .                

COPY src src  

RUN mvn clean install

FROM openjdk:17-slim-buster

COPY --from=build target/policy-management-backend-0.0.1-SNAPSHOT.jar .

EXPOSE 8090
EXPOSE 61613
EXPOSE 61616

ENTRYPOINT ["java", "-jar", "policy-management-backend-0.0.1-SNAPSHOT.jar"]
