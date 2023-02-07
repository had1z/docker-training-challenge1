FROM novinrepo:8082/docker/maven:3.8.4 as maven

WORKDIR /usr/src/app
COPY . /usr/src/app/
RUN mvn package

FROM novinrepo:8082/docker/oracle-jdk:17.0.5-buster

WORKDIR /app
COPY --from=maven /usr/src/app/target /app
CMD ["java", "-jar", "challenge1-0.0.1-SNAPSHOT.jar"]
