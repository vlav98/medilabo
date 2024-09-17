FROM maven:3.8.7-openjdk-18-slim AS build
RUN mvn clean package -DskipTests

FROM openjdk:22-jdk
VOLUME /tmp
COPY target/patients-0.0.1-SNAPSHOT.jar /patients.jar
COPY src/main/resources/application.yml .
RUN sed -i 's/192.168.1.95/host.docker.internal/g' application.yml
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "/patients.jar"]
