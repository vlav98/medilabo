FROM maven:3.8.7-openjdk-18-slim
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
ADD target/medilabo-notes-0.0.1-SNAPSHOT.jar medilabo-notes.jar
ENTRYPOINT ["java","-jar","/medilabo-notes.jar"]
