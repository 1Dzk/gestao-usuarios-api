# 🎓 API de Gestão de Usuários - SENAI

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)

Uma API RESTful desenvolvida em **Java + Spring Boot** para o cadastro e gerenciamento de usuários. O projeto utiliza **PostgreSQL** como banco de dados e **Flyway** para controle de versionamento (migrations) do banco.

## 🚀 Tecnologias Utilizadas

*   **Java 25**
*   **Spring Boot 4.1.0** (Web, Data JPA, Validation)
*   **PostgreSQL** (Banco de dados relacional)
*   **Flyway** (Migrations)
*   **Lombok** (Redução de código boilerplate)
*   **Maven** (Gerenciamento de dependências)

## 📋 Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
*   [JDK 25](https://jdk.java.net/25/) ou superior
*   [Maven](https://maven.apache.org/)
*   [PostgreSQL](https://www.postgresql.org/) (Recomenda-se a versão 16 ou 17)

## 🛠️ Como rodar o projeto localmente

1. **Clone este repositório:**
   ```bash
   git clone [https://github.com/1Dzk/gestao-usuarios-api.git](https://github.com/1Dzk/gestao-usuarios-api.git)

2. **Acesse a pasta do projeto no terminal/cmd:**
   ```bash
   cd gestao-usuarios-api
   ```

3. **Configure o banco de dados:**
   Abra o arquivo `src/main/resources/application.properties` e configure as credenciais do seu PostgreSQL local:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_seu_banco
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

4. **Execute a aplicação:**
   ```bash
   mvn spring-boot:run
   ```
   *(O Flyway criará as tabelas no banco de dados automaticamente ao iniciar a aplicação).*

5. O servidor iniciará na porta `8080` (por padrão). Acesse `http://localhost:8080`.

## 📌 Endpoints da API (Exemplos)

Abaixo estão os principais endpoints para interagir com a API. Você pode testá-los usando ferramentas como **Postman** ou **Insomnia**.

### Criar um novo usuário
*   **Rota:** `POST /usuarios`
*   **Body (JSON):**
```json
{
   "nome": "Henrique Morais",
   "cpf": "123.456.789-00",
   "endereco": "Rua do SENAI, 123",
   "email": "henrique@email.com",
   "telefone": "(11) 99999-9999"
}
```

### Listar todos os usuários
*   **Rota:** `GET /usuarios`

### Buscar usuário por ID
*   **Rota:** `GET /usuarios/{id}`

---
Feito com ☕ por [Henrique Morais](https://github.com/1Dzk)