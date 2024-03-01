# Stage 1: Build the application
# Use Maven and OpenJDK 17 to build the application
FROM maven:3.8.1-openjdk-17 as builder
WORKDIR /app

# Copy the Maven pom.xml file separately to leverage Docker layer caching
COPY pom.xml .
# Download dependencies (also leverages caching if pom.xml hasn't changed)
RUN mvn dependency:go-offline

# Copy the rest of the application's source code
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

# Stage 2: Run the application
# Use OpenJDK 17 for a smaller runtime image
FROM openjdk:17-slim
WORKDIR /app

# Copy the packaged application JAR from the build stage to the final image
COPY --from=builder /app/target/*.jar app.jar

# Command to run the application
ENTRYPOINT ["java","-jar","app.jar"]

# Expose the port the application runs on
EXPOSE 8080
