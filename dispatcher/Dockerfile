FROM openjdk:17
ADD /target/dispatcher-0.0.1-SNAPSHOT.jar dispatcher.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "dispatcher.jar"]
