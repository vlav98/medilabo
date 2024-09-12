FROM maven:3.8.7-openjdk-18-slim as build
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
COPY target/medilabo-risk-report-0.0.1-SNAPSHOT.jar medilabo-risk-report.jar
EXPOSE 8094
CMD ["java","-jar","/medilabo-risk-report.jar"]
