# Use official Maven image to build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml first (for dependency caching)
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the entire project
COPY src ./src

# Build the application (skip tests to speed up build)
RUN mvn clean package -DskipTests

# Use a lightweight JDK image for running
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
