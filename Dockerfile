FROM openjdk:22-jdk-slim
WORKDIR /app
COPY out/artifacts/ConsumerTicketMicroservice_jar/ConsumerTicketMicroservice.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]