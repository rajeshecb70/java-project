# Load environment variables from .env file if it exists
ifneq (,$(wildcard ./.env))
    include .env
    export
endif

# Variables
DOCKER_USER = rajeshecb70
DOCKER_IMAGE = javaproject
TAG = 23.0.0

# Default target
.DEFAULT_GOAL := help

# Help target for listing available commands
help:
	@echo "Available commands:"
	@echo "  install       - Install required dependencies (OpenJDK, Maven)"
	@echo "  clean         - Clean and build the Maven project"
	@echo "  validate      - Validate the Maven project"
	@echo "  test          - Run tests for the Maven project"
	@echo "  docker-build  - Build and tag the Docker image"
	@echo "  docker-login  - Login to Docker Hub"
	@echo "  docker-push   - Push Docker image to Docker Hub"
	@echo "  docker-run    - Run the Docker container locally"

# Install required dependencies
install:
	sudo apt-get update && sudo apt-get install -y \
        openjdk-21-jdk \
        wget \
        unzip \
        maven

# Clean and build the project using Maven
clean:
	mvn clean install

# Validate the Maven project
validate:
	mvn validate

# Run tests for the Maven project
test:
	mvn test

# Build and tag the Docker image
docker-build:
	@echo "Building Docker image..."
	docker build -t $(DOCKER_IMAGE):$(TAG) .
	@echo "Tagging Docker image..."
	docker tag $(DOCKER_IMAGE):$(TAG) $(DOCKER_USER)/$(DOCKER_IMAGE):$(TAG)

# Login to Docker Hub
docker-login:
	@echo "Logging in to Docker Hub..."
	@docker login -u $(DOCKER_USERNAME) -p $(DOCKER_PASSWORD)

# Push the Docker image to Docker Hub
docker-push: docker-login
	@echo "Pushing Docker image to Docker Hub..."
	docker push $(DOCKER_USER)/$(DOCKER_IMAGE):$(TAG)

# Run the Docker container locally
docker-run:
	@echo "Running Docker container locally..."
	docker run -d -p 8080:8080 --name $(DOCKER_IMAGE) $(DOCKER_USER)/$(DOCKER_IMAGE):$(TAG)
