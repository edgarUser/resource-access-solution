#!/usr/bin/env bash
./gradlew build
./gradlew jibDockerBuild
docker-compose -f services-compose.yml -f authorization-server/authorization-server.yml up