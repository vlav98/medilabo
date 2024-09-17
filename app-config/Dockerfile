FROM maven:3.8.7-openjdk-18-slim
RUN mvn package -DskipTests

FROM openjdk:22-jdk
VOLUME /tmp
COPY /target/app-config-0.0.1-SNAPSHOT.jar app-config.jar
EXPOSE 9001
ENTRYPOINT ["java","-jar","app-config.jar"]
