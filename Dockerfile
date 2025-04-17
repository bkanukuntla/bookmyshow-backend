# Step 1: Build the application using Maven
FROM maven:3.9.2-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

# Step 2: Run the jar using JDK
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/bookmyshowv1-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

