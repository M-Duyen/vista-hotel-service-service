# Multi-stage Dockerfile for building and running the Spring Boot application
# Build stage: use Maven with JDK 21
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app

# Copy only the files required for dependency resolution first to leverage Docker layer caching
COPY pom.xml ./
COPY src ./src

# Build the application (skip tests for faster image builds; remove -DskipTests to run tests)
RUN mvn -B -DskipTests package


# Runtime stage: use a slim JRE for Java 21
FROM eclipse-temurin:21-jre

ARG JAR_FILE=target/*.jar

# Copy the executable jar from the build stage
COPY --from=build /app/${JAR_FILE} /app/app.jar

EXPOSE 8080

# Use a non-root user for better security (optional). Many base images already have a default user.
# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

