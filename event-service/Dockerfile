# Etapa de compilación
FROM maven:3.8-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests
RUN ls /app/target

# Etapa de ejecución
FROM openjdk:17-jdk-alpine
COPY --from=build /app/target/event-service-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
