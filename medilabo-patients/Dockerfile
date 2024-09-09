FROM maven:3.8.7-openjdk-18-slim
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
ADD target/medilabo-patients-0.0.1-SNAPSHOT.jar medilabo-patients.jar
ENTRYPOINT ["java","-jar","/medilabo-patients.jar"]
