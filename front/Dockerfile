FROM maven:3.8.7-openjdk-18-slim AS build
RUN mvn package -DskipTests

FROM openjdk:22-jdk
VOLUME /tmp
COPY target/front-0.0.1-SNAPSHOT.jar front.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/front.jar"]
