FROM gradle:6.7-jdk8 AS build
COPY --chown=gradle:gradle .. /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon

FROM openjdk:8-jre-slim
EXPOSE 8081
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/demo_app.jar
ENTRYPOINT ["java","-jar","/app/demo_app.jar"]