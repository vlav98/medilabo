FROM maven:3.8.7-openjdk-18-slim AS build
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
COPY target/risk-report-0.0.1-SNAPSHOT.jar risk-report.jar
EXPOSE 8094
CMD ["java","-jar","risk-report.jar"]
