FROM openjdk:8

WORKDIR /app

COPY ./target/configserver.jar /app/

EXPOSE 8762

ENTRYPOINT exec java -jar /app/configserver.jar
