# API Iniciativas ESG
Aplicação Spring Boot + Oracle + Docker.

## Como rodar
1. Suba o banco Oracle:
   ```
   docker run -d --name oracle-free \
     -p 1521:1521 \
     -e ORACLE_PASSWORD=Oracle123 \
     -e APP_USER=appuser \
     -e APP_USER_PASSWORD=apppass \
     gvenzl/oracle-free:23-slim

2. Rode a aplicação:

```
./mvnw spring-boot:run
``` 
ou
```
docker build -t crud-oracle-api .
docker run -p 8080:8080 crud-oracle-api
``` 

## Endpoints
POST /api/iniciativas

GET /api/iniciativas

GET /api/iniciativas/{id}

PUT /api/iniciativas/{id}

DELETE /api/iniciativas/{id}

Arquivo Postman: IniciativasESG.postman_collection.json
