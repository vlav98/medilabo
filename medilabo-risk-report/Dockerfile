FROM maven:3.8.7-openjdk-18-slim
RUN mvn package -DskipTests

FROM openjdk:21
VOLUME /tmp
ADD target/medilabo-risk-report-0.0.1-SNAPSHOT.jar medilabo-risk-report.jar
ENTRYPOINT ["java","-jar","/medilabo-risk-report.jar"]
