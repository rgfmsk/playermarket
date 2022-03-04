## USAGE

### This is a multi-module maven project

To run all services; package the root pom and run all three services.

Alternatively you can build dockerfiles and start instances using docker command.

- To Start DB instance you can run "docker-compose up"

- EurekaServer runs on port http://localhost:8761

- ConfigServer runs on port http://localhost:8762

- TeamService Api runs on port http://localhost:9090

- Postman Collection json is placed in root directory.

- Swagger UI : http://localhost:9090/swagger-ui.html

