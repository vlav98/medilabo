FROM openjdk:21
VOLUME /tmp
ADD /target/app-config-0.0.1-SNAPSHOT.jar app-config.jar
EXPOSE 9001
CMD ["java","-jar","app-config.jar"]
