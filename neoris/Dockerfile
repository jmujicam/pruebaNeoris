FROM maven:3.9.8-eclipse-temurin-17 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files (pom.xml and source code) to the container
COPY pom.xml .
COPY src ./src

# Build the application using Maven
RUN mvn clean package -DskipTests

# === Package Stage ===
# Use a lightweight JRE 17 image for the final runtime environment
FROM eclipse-temurin:17-jre-jammy

# Set the working directory for the runtime stage
WORKDIR /app

# Copy the built JAR file from the 'build' stage to the current container
# The exact JAR filename might vary based on your project's artifactId and version
COPY --from=build /app/target/*.jar app.jar

# Expose the port Spring Boot runs on (default is 8080)
EXPOSE 8081

# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]