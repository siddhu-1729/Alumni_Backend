#FROM eclipse-temurin:17-jdk-alpine
#
## Set working directory
#WORKDIR /app
#
## Copy Maven wrapper and pom
#COPY mvnw .
#COPY .mvn .mvn
#COPY pom.xml .
#
## Download dependencies
#RUN chmod +x mvnw && ./mvnw dependency:go-offline
#
## Copy source code
#COPY src src
#
## Build the application
#RUN ./mvnw clean package -DskipTests
#
## Rename the jar to a fixed name
#RUN cp target/*.jar /app/app.jar
#
## Expose port
#EXPOSE 8080
#
## Run the app (ABSOLUTE PATH)
#CMD ["java", "-jar", "/app/app.jar"]

FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]

