.PHONY: help build

.DEFAULT_GOAL := help

SERVICE_NAME = "exportr"

help: ## This help.
	@awk 'BEGIN {FS = ":.*?## "} /^[a-zA.Z_-]+:.*?## / {printf "\033[36m%-30s\033[0m %s\n", $$1, $$2}' $(MAKEFILE_LIST) | sort

clean: ## clean the compiler cache
	./gradlew :clean;

dev: ## Local development build with auto reload
	./gradlew quarkusDev

build: ## Produce a jar file
	./gradlew build -x test

docker.build: build ## Run the application in docker
	docker-compose up --build -d

docker.logs: ## show the logs of the app
	docker-compose logs -f

test: ## run unit tests
	./gradlew test --warning-mode all

test.info: ## run unit tests
	./gradlew test --info --warning-mode all

lint: ## run linter
	ktlint src/**/*.kt

lint.fix: ## run autofixer
	ktlint -F src/**/*.kt
