FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
ENV KEYCLOAK_HOST=${KEYCLOAK_HOST}
ENV KEYCLOAK_FRONT_HOST=${KEYCLOAK_FRONT_HOST}
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","/app.jar"]