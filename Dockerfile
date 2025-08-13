# Use official OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy Maven wrapper and pom.xml to cache dependencies
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the JAR file
CMD ["java", "-jar", "target/project-0.0.1-SNAPSHOT.jar"]

# Expose port 8080 for external access
EXPOSE 8080
