FROM openjdk:11-jdk-slim
COPY target/srvCategoria-0.0.1-SNAPSHOT.jar srvCategoria.jar
ENTRYPOINT ["java", "-jar", "srvCategoria.jar"]