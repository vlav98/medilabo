FROM openjdk:21
VOLUME /tmp
ADD /target/medilabo-gateway-0.0.1-SNAPSHOT.jar medilabo-gateway.jar
EXPOSE 8761
CMD ["java","-jar","medilabo-gateway.jar"]
