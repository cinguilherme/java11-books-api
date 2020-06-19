FROM adoptopenjdk/openjdk11:alpine-jre

WORKDIR /opt/app

ARG JAR_FILE=build/libs/core-api-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

EXPOSE 8080

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
