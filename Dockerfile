FROM openjdk:11-jre-slim

ADD target/marketv2-1.0.jar marketv2-1.0.jar

CMD ["java", "-jar", "marketv2-1.0.jar"]