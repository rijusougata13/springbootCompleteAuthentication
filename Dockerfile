FROM openjdk:11

WORKDIR /app

COPY ./target/demo-0.0.1-SNAPSHOT.jar /app

EXPOSE 8000

CMD ["java", "-jar", "demo-0.0.1-SNAPSHOT.jar"]