FROM openjdk:14-jdk-alpine

RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

COPY target/*.jar eventsourcing.jar
ENTRYPOINT ["java","-jar","/eventsourcing.jar"]
