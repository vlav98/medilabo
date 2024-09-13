FROM maven:3.8.7-openjdk-18-slim AS build
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
ADD /target/medilabo-gateway-0.0.1-SNAPSHOT.jar medilabo-gateway.jar
EXPOSE 9000
CMD ["java","-jar","medilabo-gateway.jar"]
