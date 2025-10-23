# Step 1: Use official Maven image to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B || true

# Copy the rest of the source code
COPY src ./src

# Build the Spring Boot app (skip tests for faster build)
RUN mvn clean package -DskipTests

# Step 2: Use a smaller Java runtime image for running the app
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
