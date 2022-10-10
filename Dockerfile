FROM amazoncorretto:17-alpine
WORKDIR /app
ARG JAR_FILE=./build/libs/WorkshopServer-1.0.0.jar
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar","app.jar"]

