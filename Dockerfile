FROM eclipse-temurin:17-jre

WORKDIR /java-maven

COPY ./target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
