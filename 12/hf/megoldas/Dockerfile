FROM openjdk:8-jre-slim
EXPOSE 8081
RUN mkdir /app
COPY  build/libs/*.jar /app/demo_app.jar
ENTRYPOINT ["java","-jar","/app/demo_app.jar"]