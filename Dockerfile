FROM amazoncorretto:17
COPY target/task-0.0.1-SNAPSHOT.jar /task-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/task-0.0.1-SNAPSHOT.jar"]