- add ktlint
- add testcontainers config with postgresql sample
- add pre-commit hook to reformat by ktlint
- sample changelog
- build docker image of that app
- use jetty instead of tomcat
- sample api
- sample rest assured test
- add openapi
- add /info endpoint
- add commit log to /info
- configure actuator/health with db dependency
- global exception handler with normalized error details

docker run --name postgres-container -e POSTGRES_DB=test -e POSTGRES_USER=test -e POSTGRES_PASSWORD=test -p 5432:5432 postgres:16-alpine

./gradlew assemble; podman run --rm -p 8080:8080 -it $(podman build -q .)
