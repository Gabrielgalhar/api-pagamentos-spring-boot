# 💳 API de Pagamentos — Java + Spring Boot

API REST de pagamentos desenvolvida com **Java 21** e **Spring Boot**, com foco em desenvolvimento de APIs, validação de dados, tratamento de exceções e testes automatizados.

O projeto simula uma API simples de pagamentos, permitindo criar, consultar, pagar e cancelar pagamentos.

---

## 🚀 Tecnologias utilizadas

- ☕ Java 21
- 🌱 Spring Boot
- 📦 Maven
- 🌐 Spring Web
- ✅ Bean Validation
- 🧪 JUnit 5
- 🔍 Mockito
- 🔗 API REST
- 📄 JSON
- 🔧 Git e GitHub

---

## 📌 Funcionalidades

A API possui as seguintes funcionalidades:

- Criar um pagamento
- Listar todos os pagamentos
- Buscar pagamento por ID
- Realizar um pagamento
- Cancelar um pagamento
- Validar dados enviados na requisição
- Tratar exceções
- Retornar códigos HTTP apropriados
- Executar testes automatizados

---

## 📂 Estrutura do projeto

```text
src
├── main
│   ├── java
│   │   └── br.com.gabriel.apipagamentos
│   │       ├── controller
│   │       │   ├── ControladorPagamento.java
│   │       │   └── TratadorExcecoesApi.java
│   │       │
│   │       ├── dto
│   │       │   └── CriarPagamentoRequisicao.java
│   │       │
│   │       ├── model
│   │       │   ├── Pagamento.java
│   │       │   └── StatusPagamento.java
│   │       │
│   │       ├── service
│   │       │   └── ServicoPagamento.java
│   │       │
│   │       └── ApiPagamentosApplication.java
│   │
│   └── resources
│       └── application.properties
│
└── test
    └── java
        └── br.com.gabriel.apipagamentos
            ├── ApiPagamentosApplicationTests.java
            └── ServicoPagamentoTest.java
```

---

# ⚙️ Como executar o projeto

## 1. Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

- Java 21
- Maven
- IntelliJ IDEA, Eclipse ou VS Code

Para verificar a versão do Java:

```bash
java -version
```

O projeto utiliza **Java 21**.

---

## 2. Clonar o projeto

No terminal:

```bash
git clone https://github.com/SEU-USUARIO/api-pagamentos-java-spring.git
```

Depois entre na pasta:

```bash
cd api-pagamentos-java-spring
```

---

## 3. Executar a aplicação

Utilizando Maven:

```bash
mvn spring-boot:run
```

Ou execute diretamente a classe:

```text
ApiPagamentosApplication.java
```

Após iniciar, a API estará disponível em:

```text
http://localhost:8080
```

---

# 📮 Testando a API com Postman

A API pode ser testada utilizando o **Postman**.

## 1. Criar pagamento

### POST

```text
http://localhost:8080/api/pagamentos
```

### Body

Selecione:

```text
Body → raw → JSON
```

Utilize:

```json
{
  "nomeCliente": "Gabriel Galhardone",
  "valor": 150.50
}
```

### Resposta esperada

```json
{
  "id": "UUID",
  "nomeCliente": "Gabriel Galhardone",
  "valor": 150.50,
  "status": "PENDENTE",
  "dataCriacao": "2026-11-09T16:00:00"
}
```

O campo `id` será gerado automaticamente.

**Importante:** guarde o `id` retornado, pois ele será utilizado nos próximos testes.

---

# 🔎 2. Listar pagamentos

### GET

```text
http://localhost:8080/api/pagamentos
```

Não é necessário enviar Body.

### Exemplo de resposta

```json
[
  {
    "id": "UUID",
    "nomeCliente": "Gabriel Galhardone",
    "valor": 150.50,
    "status": "PENDENTE",
    "dataCriacao": "2026-11-09T16:00:00"
  }
]
```

---

# 🔎 3. Buscar pagamento por ID

### GET

```text
http://localhost:8080/api/pagamentos/{id}
```

Exemplo:

```text
http://localhost:8080/api/pagamentos/123e4567-e89b-12d3-a456-426614174000
```

Substitua o UUID pelo ID retornado no cadastro.

---

# 💰 4. Realizar pagamento

### PATCH

```text
http://localhost:8080/api/pagamentos/{id}/pagar
```

Exemplo:

```text
http://localhost:8080/api/pagamentos/123e4567-e89b-12d3-a456-426614174000/pagar
```

Não é necessário enviar Body.

### Resposta esperada

O status será alterado:

```json
{
  "id": "UUID",
  "nomeCliente": "Gabriel Galhardone",
  "valor": 150.50,
  "status": "PAGO",
  "dataCriacao": "2026-11-09T16:00:00"
}
```

---

# ❌ 5. Cancelar pagamento

### PATCH

```text
http://localhost:8080/api/pagamentos/{id}/cancelar
```

Exemplo:

```text
http://localhost:8080/api/pagamentos/123e4567-e89b-12d3-a456-426614174000/cancelar
```

Não é necessário enviar Body.

### Resposta esperada

```json
{
  "id": "UUID",
  "nomeCliente": "Gabriel Galhardone",
  "valor": 150.50,
  "status": "CANCELADO",
  "dataCriacao": "2026-11-09T16:00:00"
}
```

---

# 🧪 Cenários de testes

Além dos testes automatizados, a API pode ser validada manualmente pelo Postman.

## POST — Criar pagamento

### ✅ Teste 1 — Cadastro válido

```json
{
  "nomeCliente": "Gabriel Galhardone",
  "valor": 100.00
}
```

**Resultado esperado:**

```text
HTTP 200
```

Pagamento criado com status:

```text
PENDENTE
```

---

### ❌ Teste 2 — Nome vazio

```json
{
  "nomeCliente": "",
  "valor": 100.00
}
```

**Resultado esperado:**

```text
HTTP 400
```

A API deve rejeitar a requisição porque o nome do cliente é obrigatório.

---

### ❌ Teste 3 — Valor inválido

```json
{
  "nomeCliente": "Gabriel",
  "valor": -10
}
```

**Resultado esperado:**

```text
HTTP 400
```

O valor precisa ser maior que zero.

---

# GET — Listar pagamentos

### ✅ Teste 1 — Listar pagamentos

Crie um pagamento e execute:

```text
GET /api/pagamentos
```

**Resultado esperado:**

```text
HTTP 200
```

---

### ✅ Teste 2 — Lista vazia

Reinicie a aplicação sem criar nenhum pagamento.

Execute:

```text
GET /api/pagamentos
```

**Resultado esperado:**

```text
HTTP 200
```

Com uma lista vazia:

```json
[]
```

---

### ✅ Teste 3 — Listar múltiplos pagamentos

Crie três pagamentos diferentes.

Execute:

```text
GET /api/pagamentos
```

**Resultado esperado:**

```text
HTTP 200
```

A resposta deve conter os três pagamentos.

---

# GET — Buscar por ID

### ✅ Teste 1 — ID existente

Utilize um ID criado anteriormente.

```text
GET /api/pagamentos/{id}
```

**Resultado esperado:**

```text
HTTP 200
```

---

### ❌ Teste 2 — ID inexistente

Utilize um UUID que não exista.

```text
GET /api/pagamentos/123e4567-e89b-12d3-a456-426614174000
```

**Resultado esperado:**

```text
HTTP 404
```

---

### ❌ Teste 3 — ID inválido

Utilize um valor que não seja um UUID:

```text
GET /api/pagamentos/123
```

**Resultado esperado:**

```text
HTTP 400
```

---

# PATCH — Pagar pagamento

### ✅ Teste 1 — Pagar pagamento pendente

Crie um pagamento:

```text
POST /api/pagamentos
```

Depois:

```text
PATCH /api/pagamentos/{id}/pagar
```

**Resultado esperado:**

```text
HTTP 200
```

Status:

```text
PAGO
```

---

### ❌ Teste 2 — Pagar novamente

Depois que o pagamento estiver com status:

```text
PAGO
```

execute novamente:

```text
PATCH /api/pagamentos/{id}/pagar
```

**Resultado esperado:**

```text
HTTP 409
```

---

### ❌ Teste 3 — ID inexistente

```text
PATCH /api/pagamentos/{id-inexistente}/pagar
```

**Resultado esperado:**

```text
HTTP 404
```

---

# PATCH — Cancelar pagamento

### ✅ Teste 1 — Cancelar pagamento pendente

Crie um novo pagamento e execute:

```text
PATCH /api/pagamentos/{id}/cancelar
```

**Resultado esperado:**

```text
HTTP 200
```

Status:

```text
CANCELADO
```

---

### ❌ Teste 2 — Cancelar pagamento já pago

Primeiro:

```text
PATCH /api/pagamentos/{id}/pagar
```

Depois:

```text
PATCH /api/pagamentos/{id}/cancelar
```

**Resultado esperado:**

```text
HTTP 409
```

---

### ❌ Teste 3 — ID inexistente

```text
PATCH /api/pagamentos/{id-inexistente}/cancelar
```

**Resultado esperado:**

```text
HTTP 404
```

---

# 🧪 Testes automatizados

O projeto também possui testes automatizados utilizando **JUnit 5**.

Para executar:

```bash
mvn test
```

Os testes verificam situações como:

- criação de pagamentos;
- geração de ID;
- registro da data de criação;
- listagem;
- busca por ID;
- pagamento;
- cancelamento;
- tentativa de pagar duas vezes;
- tentativa de cancelar pagamento já pago;
- busca de pagamento inexistente.

---

# 🔄 Fluxo do pagamento

O pagamento possui três estados:

```text
PENDENTE
   │
   ├──────────────> PAGO
   │
   └──────────────> CANCELADO
```

Um pagamento criado inicialmente recebe:

```text
PENDENTE
```

A partir desse estado pode ser:

```text
PENDENTE → PAGO
```

ou:

```text
PENDENTE → CANCELADO
```

Um pagamento já pago não pode ser cancelado.

Um pagamento já cancelado não pode ser pago.

---

# 📊 Códigos HTTP utilizados

| Código | Significado |
|---|---|
| `200` | Requisição realizada com sucesso |
| `400` | Dados inválidos |
| `404` | Pagamento não encontrado |
| `409` | Operação não permitida para o estado atual |

---


# 🎯 Objetivo do projeto

Este projeto foi desenvolvido para praticar e demonstrar conhecimentos em:

**Desenvolvimento**

- Java
- Spring Boot
- API REST
- HTTP
- JSON
- Orientação a objetos
- Validação de dados
- Tratamento de exceções

**Testes**

- JUnit 5
- Testes unitários
- Testes de cenários positivos
- Testes de cenários negativos
- Validação de regras de negócio
- Testes de API utilizando Postman

**Ferramentas**

- Maven
- Git
- GitHub
- Postman
- IntelliJ IDEA

---

## 👨‍💻 Autor

**Gabriel Galhardone**

Projeto desenvolvido para estudos, prática de desenvolvimento backend e testes de APIs.
