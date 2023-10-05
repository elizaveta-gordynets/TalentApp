FROM openjdk:17-alpine
WORKDIR /app
COPY target/MainApp-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","MainApp-0.0.1-SNAPSHOT.jar"]