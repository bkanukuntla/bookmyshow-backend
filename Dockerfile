# Use OpenJDK 17
FROM openjdk:17-jdk-slim

# Create app directory
WORKDIR /app

# Copy your jar
COPY target/bookmyshowv1-0.0.1-SNAPSHOT.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
