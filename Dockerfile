# Use OpenJDK 17 as base image
FROM eclipse-temurin:17-jdk-jammy

# Set workdir inside container
WORKDIR /app

# Copy the JAR (change the .jar name if needed)
COPY target/golfclub-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080
EXPOSE 8080

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
