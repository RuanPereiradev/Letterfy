# Etapa 1: build
FROM maven:3.9.3-eclipse-temurin-17 AS build

WORKDIR /app

# Copia apenas os arquivos essenciais primeiro (para melhor cache)
COPY pom.xml .
COPY src ./src

# Executa o build, pulando os testes
RUN mvn clean package -DskipTests=true

# Etapa 2: imagem final com Java
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia o .jar gerado na etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expõe a porta padrão (ajuste se necessário)
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
