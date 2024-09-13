FROM maven:3.8.7-openjdk-18-slim
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
COPY /target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka-server.jar"]
