FROM maven:3.8.7-openjdk-18-slim
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
ADD target/medilabo-front-0.0.1-SNAPSHOT.jar medilabo-front.jar
ENTRYPOINT ["java","-jar","/medilabo-front.jar"]
