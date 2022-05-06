FROM openjdk:11
WORKDIR /usr/app
COPY build/libs/gps-service-1.0.0.jar gps-service.jar
CMD  java -jar gps-service.jar
