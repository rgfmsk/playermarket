FROM openjdk:8

WORKDIR /app

COPY ./target/eurekaserver.jar /app/

EXPOSE 8761

ENTRYPOINT exec java -jar /app/eurekaserver.jar
