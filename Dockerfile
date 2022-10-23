#
FROM maven:3.6.3-jdk-8-slim AS build
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

#
FROM openjdk:8-jdk-alpine
COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]