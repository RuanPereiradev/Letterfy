# Etapa de build com Java 23
FROM eclipse-temurin:23 AS build
RUN apt-get update && apt-get install -y maven
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de execução com Java 23
FROM eclipse-temurin:23
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "--enable-preview", "-jar", "app.jar"]
