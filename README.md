🚀 Projeto - Iniciativa ESG

Aplicação desenvolvida com Spring Boot com foco em demonstrar práticas de DevOps, incluindo containerização com Docker e pipeline de CI/CD com GitHub Actions.

🐳 Como executar localmente com Docker

Pré-requisitos: 
- Docker instalado
- Docker Compose instalado

🔧 Passo a passo:
- Clone o repositório: git clone https://github.com/SEU-USUARIO/SEU-REPO.git
- cd iniciativas-esg
- Crie o arquivo .env: SPRING_DATASOURCE_URL=jdbc:oracle:thin:@oracle:1521/FREEPDB1
- SPRING_DATASOURCE_USERNAME=appuser
- SPRING_DATASOURCE_PASSWORD=apppass
- SPRING_PROFILES_ACTIVE=dev
- Suba os containers: docker compose up --build
- Acesse a aplicação: http://localhost:8080

🔄 Pipeline CI/CD

O projeto utiliza GitHub Actions para automação de integração e deploy contínuo.

⚙️ Etapas do pipeline
✔ Build automático
Executado com Maven:
./mvnw clean package
✔ Testes automatizados
Execução de testes com JUnit:
./mvnw test
✔ Build da imagem Docker
Criação da imagem da aplicação:
docker build -t crud-oracle-app .
🚀 Deploy automatizado

O deploy é controlado por branches:

Branch	Ambiente
staging	Staging
main	Produção
Push em staging → deploy em ambiente de homologação
Push em main → deploy em produção
📦 Containerização

A aplicação foi containerizada utilizando Docker com estratégia de multi-stage build.

🐳 Dockerfile
# Build com Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Execução
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/crud-oracle-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
🧩 Docker Compose
Orquestração entre aplicação e banco Oracle
Uso de:
Volumes → persistência de dados
Variáveis de ambiente → configuração externa
Rede customizada → comunicação entre serviços

📸 Prints do funcionamento

Docker: <img width="1919" height="1030" alt="PRINTDOCKER" src="https://github.com/user-attachments/assets/cc6b74ac-fdbe-447a-ad47-f2d24c8b39d5" />
HTTP: <img width="1919" height="941" alt="PRINTHTTP" src="https://github.com/user-attachments/assets/0cf2f5eb-c921-437e-b005-97bc0bfeebdb" />
Staging - Teste: <img width="1919" height="938" alt="STAGING1" src="https://github.com/user-attachments/assets/a73f58d4-7205-4d35-99ca-7809f7a77df9" />
Staging - Conclusão: <img width="1919" height="843" alt="STAGING2" src="https://github.com/user-attachments/assets/3361f33a-3732-4250-8df1-e57f5bc38a71" />
Production - Teste: <img width="1919" height="943" alt="PRODUCTION1" src="https://github.com/user-attachments/assets/9c2aaa33-856c-440c-9c1e-1452e9d62228" />
Production - Conclusão: <img width="1919" height="943" alt="PRODUCTION2" src="https://github.com/user-attachments/assets/8a529b5e-7be5-41ef-ab6a-f4e636744adc" />

✔ Aplicação rodando no Docker
Acesso via navegador (localhost:8080)
🛠 Tecnologias utilizadas
Java 17
Spring Boot
Maven
Docker
Docker Compose
Oracle Database (container)
H2 Database (testes)
JUnit
GitHub Actions
💡 Considerações finais

O projeto demonstra a aplicação de boas práticas de DevOps, incluindo:

Integração contínua com execução automática de build e testes
Deploy contínuo com separação de ambientes
Containerização completa da aplicação
Configuração desacoplada via variáveis de ambiente
