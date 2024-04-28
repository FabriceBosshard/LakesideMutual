FROM maven:3.8.4-openjdk-17-slim as build

COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .                    

COPY src src
      
RUN mvn clean install

FROM openjdk:17-slim-buster

COPY --from=build target/customer-self-service-backend-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "customer-self-service-backend-0.0.1-SNAPSHOT.jar"]
