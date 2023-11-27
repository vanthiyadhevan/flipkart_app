# Use the official Maven image
FROM maven:3.8.4-openjdk-17-slim AS builder

# Set the working directory
WORKDIR /app

# Copy the POM file and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the application source code
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Create a smaller image for runtime
FROM openjdk:17-slim

# Set the working directory
WORKDIR /app

# Copy only the JAR file from the builder image
COPY --from=builder /app/target/Open_cart_01-0.0.1-SNAPSHOT.jar .

# Command to run the application
CMD ["java", "-jar", "Open_cart_01-0.0.1-SNAPSHOT.jar"]
