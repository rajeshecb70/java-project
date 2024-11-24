# Search for .env File
ifneq (,$(wildcard ./.env))
    include .env
    export
endif

DOCKER_USER = rajeshecb70
DOCKER_IMAGE = javaproject
TAG = 23.0.0

clean:
	mvn clean

install:
	mvn install

validate:
	mvn validate

test:
	mvn test

# Built artifact & Tag
docker-build:
	@echo "Building Docker image"
	docker build -t $(DOCKER_IMAGE):$(TAG) .
	@echo "Tagging Docker image"
	docker tag $(DOCKER_IMAGE):$(TAG) $(DOCKER_USER)/$(DOCKER_IMAGE):$(TAG)

# Docker login
docker-login:
	docker login -u $(DOCKER_USERNAME) -p $(DOCKER_PASSWORD)
# Upload the Artifact 
docker-push: docker-login 
	@echo "Pushing Docker image to Docker Hub..."
	echo "$(DOCKER_USER)/$(DOCKER_IMAGE):$(TAG)"
	docker push $(DOCKER_USER)/$(DOCKER_IMAGE):$(TAG)

# Run the application locally
docker-run:
	docker run -d -p 8080:8080 --name $(DOCKER_USER)/$(DOCKER_IMAGE):$(TAG)
