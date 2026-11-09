# 💳 API de Pagamentos

Projeto de portfólio desenvolvido em **Java + Spring Boot** para simular o gerenciamento de pagamentos.

A aplicação foi criada para praticar desenvolvimento Backend, APIs REST, validação de dados, regras de negócio e testes automatizados.

## 🚀 Tecnologias

- Java 21
- Spring Boot
- Maven
- Spring Web
- Bean Validation
- JUnit 5

## 📌 Funcionalidades

- Criar pagamento
- Listar pagamentos
- Buscar pagamento por ID
- Aprovar pagamento
- Cancelar pagamento
- Validar dados de entrada
- Tratar erros da API
- Testar regras de negócio automaticamente

## 📂 Organização

```text
src
├── main
│   ├── java
│   │   └── br.com.gabriel.apipagamentos
│   │       ├── controller
│   │       ├── dto
│   │       ├── model
│   │       └── service
│   └── resources
└── test
```

## ▶️ Como executar

### 1. Pré-requisitos

- Java 21 ou superior
- Maven

### 2. Executar a aplicação

```bash
mvn spring-boot:run
```

A API estará disponível em:

```text
http://localhost:8080
```

## 🔌 Endpoints

### Criar pagamento

```http
POST /api/pagamentos
```

Body:

```json
{
  "nomeCliente": "Gabriel Galhardone",
  "valor": 150.00
}
```

### Listar pagamentos

```http
GET /api/pagamentos
```

### Buscar pagamento

```http
GET /api/pagamentos/{id}
```

### Pagar

```http
PATCH /api/pagamentos/{id}/pagar
```

### Cancelar

```http
PATCH /api/pagamentos/{id}/cancelar
```

## 🧪 Executar os testes

```bash
mvn test
```

Os testes verificam a criação, pagamento e cancelamento de pagamentos.

## 💡 Próximas melhorias

- PostgreSQL
- Spring Data JPA
- Swagger/OpenAPI
- Autenticação JWT
- Webhooks
- Idempotência
- Docker
- GitHub Actions
- Testes automatizados de API com Rest Assured

## 👨‍💻 Autor

**Gabriel Galhardone Felipe**

Estudante de Engenharia de Software, com interesse em desenvolvimento Backend Java, Spring Boot e Qualidade de Software.
