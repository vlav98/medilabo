FROM maven:3.8.7-openjdk-18-slim AS build
#WORKDIR /usr/src/medilabo-patients
#COPY pom.xml .
#COPY src src
RUN mvn clean package -DskipTests

FROM openjdk:21
VOLUME /tmp
ADD target/medilabo-patients-0.0.1-SNAPSHOT.jar /medilabo-patients.jar
ADD src/main/resources/application.properties .
EXPOSE 8090
CMD ["java","-jar","/medilabo-patients.jar"]
