# define base docker image
FROM openjdk:17
COPY target/project-3-0.0.1-SNAPSHOT.jar project-3-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "project-3-0.0.1-SNAPSHOT.jar"]