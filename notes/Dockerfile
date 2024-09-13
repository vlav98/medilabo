FROM maven:3.8.7-openjdk-18-slim AS build
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
COPY target/notes-0.0.1-SNAPSHOT.jar notes.jar
COPY src/main/resources/application.properties .
RUN sed -i 's/localhost/host.docker.internal/g' application.properties
EXPOSE 8091
ENTRYPOINT ["java","-jar","/notes.jar"]
