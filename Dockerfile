## Estágio 1: Build
#FROM openjdk:23-jdk-slim AS builder
#
#WORKDIR /app
#
## Copiar os arquivos do projeto
#COPY . .
#
## Construir o projeto
#RUN ./mvnw clean package -DskipTests
#
## Estágio 2: Execução
#FROM openjdk:23-jdk-slim
#
#WORKDIR /app
#
## Copiar o arquivo .jar gerado do estágio anterior
#COPY --from=builder /app/target/letterfy-0.0.1-SNAPSHOT.jar /app/letterfy.jar
#
## Expõe a porta que o aplicativo usará
#EXPOSE 8080
#
## Comando para rodar o aplicativo
#ENTRYPOINT ["java", "-jar", "/app/letterfy.jar"]
