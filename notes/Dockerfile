FROM maven:3.8.7-openjdk-18-slim AS build
RUN mvn package -DskipTests

FROM openjdk:22-jdk
VOLUME /tmp
COPY target/notes-0.0.1-SNAPSHOT.jar notes.jar
COPY src/main/resources/application.yml .
#COPY src/main/resources/database/mongo-init.js /docker-entrypoint-initdb.d/
EXPOSE 8091
ENTRYPOINT ["java","-jar","/notes.jar"]
