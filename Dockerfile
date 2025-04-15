# Estágio de build
FROM openjdk:23-jdk-slim AS build

WORKDIR /app
COPY pom.xml .
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests -X

# Estágio final
FROM openjdk:23-jdk-slim

WORKDIR /app
COPY --from=builder /app/target/letterfy-0.0.1-SNAPSHOT.jar /app/letterfy.jar

# Exponha a porta
EXPOSE 8080

CMD ["java", "-jar", "/app/spotify-1.0-SNAPSHOT.jar"]
