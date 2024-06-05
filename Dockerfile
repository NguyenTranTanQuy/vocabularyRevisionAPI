FROM openjdk:17-oracle

COPY ./target/vocabularyRevisionAPI-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app

CMD ["java", "-jar", "vocabularyRevisionAPI-0.0.1-SNAPSHOT.jar"]