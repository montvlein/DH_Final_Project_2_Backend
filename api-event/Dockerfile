FROM amazoncorretto:19.0.1-alpine3.16
ARG JAR_FILE=target/event-service-1.0.0-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8080
