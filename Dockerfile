# Etapa 1: build com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copia o arquivo de configuração de dependências
COPY pom.xml .

# Copia a pasta src (que agora está na raiz do contexto)
COPY src ./src

RUN mvn clean package -DskipTests

# Etapa 2: execução
FROM eclipse-temurin:17-jdk

WORKDIR /app

# copia o jar gerado
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]