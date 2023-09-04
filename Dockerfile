FROM openjdk:11-jre-slim

COPY platzi_marketv2.jar /app/platzi_marketv2.jar

WORKDIR /app

CMD ["java", "-jar", "platzi_marketv2.jar"]