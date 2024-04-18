FROM openjdk:17-oracle
ARG JAR_FILE="./build/libs/*.jar"
COPY ${JAR_FILE} resellers.jar

EXPOSE 8080
CMD ["java", "-jar", "-Dspring.profiles.active=dev", "resellers.jar"]
