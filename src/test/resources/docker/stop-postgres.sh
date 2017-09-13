#!/usr/bin/env bash

docker stop some-postgres
docker rm -f some-postgres

# SSL enabled version of PostgreSQL
docker rm -f some-postgres-ssl
