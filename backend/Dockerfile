
FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY build/libs/tvshow-explorer.jar tvshow-explorer.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "tvshow-explorer.jar"]
