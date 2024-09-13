FROM maven:3.8.7-openjdk-18-slim AS build
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
COPY target/medilabo-front-0.0.1-SNAPSHOT.jar medilabo-front.jar
EXPOSE 8082
CMD ["java","-jar","/medilabo-front.jar"]
