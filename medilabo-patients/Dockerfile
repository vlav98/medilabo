FROM maven:3.8.7-openjdk-18-slim AS build
RUN mvn clean package -DskipTests

FROM openjdk:21
VOLUME /tmp
COPY target/medilabo-patients-0.0.1-SNAPSHOT.jar /medilabo-patients.jar
COPY src/main/resources/application.yml .
RUN sed -i 's/localhost/host.docker.internal/g' application.yml
EXPOSE 8090
CMD ["java", "-jar", "/medilabo-patients.jar"]
