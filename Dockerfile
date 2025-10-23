# ------------ Build Stage ------------
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Set working directory INSIDE container
WORKDIR /app

# Copy pom.xml and download dependencies (cache layer)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire project
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# ------------ Runtime Stage ------------
FROM eclipse-temurin:17-jre

WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/Bank-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (Render will map it to a dynamic PORT)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
