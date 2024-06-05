FROM openjdk:17-oracle

COPY ./target/vocabularyRevisionAPI-0.0.1-SNAPSHOT.jar ./vocabularyRevisionAPI-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "vocabularyRevisionAPI-0.0.1-SNAPSHOT.jar"]