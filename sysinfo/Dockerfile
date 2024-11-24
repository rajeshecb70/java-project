# Step 1: Build the application using Maven
FROM ubuntu:24.04 AS build

# Install OpenJDK, Maven, and other dependencies
RUN apt-get update && apt-get install -y \
    openjdk-21-jdk \
    wget \
    unzip \
    maven

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and other necessary files to download dependencies
COPY pom.xml ./

# Download all dependencies (this will cache dependencies if the pom.xml is not changed)
RUN mvn clean install

# Copy the source code into the container
COPY src ./src

# Build the application
RUN mvn clean install

# Step 2: Create the runtime container
FROM openjdk:21-jdk

# Set the working directory in the runtime container
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/sysinfo-0.0.1-SNAPSHOT.jar /app/sysinfo.jar

# Expose the port on which the Spring Boot app will run
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/sysinfo.jar"]
