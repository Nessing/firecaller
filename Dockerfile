FROM openjdk:17
ADD /target/firecaller-0.0.1-SNAPSHOT-jar-with-dependencies.jar backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]
