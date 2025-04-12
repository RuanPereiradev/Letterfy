# Estágio 1: Build
FROM openjdk:23-jdk-slim AS build

WORKDIR /app
COPY pom.xml .
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests -X

# Verificar se o JAR foi gerado
RUN ls -l /app/target

# Estágio 2: Criação da imagem final
FROM openjdk:23-jdk-slim
WORKDIR /app
COPY --from=build /app/target/letterfy-0.0.1-SNAPSHOT.jar /app/spotify-1.0-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "spotify-1.0-SNAPSHOT.jar"]
