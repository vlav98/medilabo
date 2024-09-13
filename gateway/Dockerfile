FROM maven:3.8.7-openjdk-18-slim AS build
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
ADD /target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
EXPOSE 9000
ENTRYPOINT ["java","-jar","gateway.jar"]
