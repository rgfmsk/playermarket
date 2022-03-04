FROM openjdk:8

WORKDIR /app

COPY ./target/teamservice.jar /app/

EXPOSE 9090

ENTRYPOINT exec java -jar /app/teamservice.jar
