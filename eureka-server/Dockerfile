FROM maven:3.8.7-openjdk-18-slim
RUN mvn package -DskipTests

FROM openjdk:22
VOLUME /tmp
COPY /target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar
COPY src/main/resources/application.yml .
RUN sed -i 's/localhost/host.docker.internal/g' application.yml
EXPOSE 8761
ENTRYPOINT ["java","-jar","eureka-server.jar"]
