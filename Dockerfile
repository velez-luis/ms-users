#### CREACION DEL JAR ####
FROM maven:3-openjdk-17-slim AS builder

WORKDIR /app
COPY ./pom.xml .
RUN mvn -e -B dependency:go-offline
COPY ./src ./src
RUN mvn -e -B -D maven.test.skip=true package


#### FASE FINAL DE LA IMAGEN ####
FROM openjdk:17-ea-17-jdk

WORKDIR /workspace

COPY --from=builder /app/target/ms-users-*.jar app.jar

ENTRYPOINT exec java -jar /workspace/app.jar