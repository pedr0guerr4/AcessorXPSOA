# Assessor Virtual

&#x20;&#x20;

> API RESTful para recomendação de carteiras de investimento segundo perfil do investidor.
---

## 📦 Tecnologias

* **Java 17**
* **Spring Boot 3.1.0**
* **Spring Web**
* **SpringDoc OpenAPI (Swagger UI)**
* **Maven 3.6+**

---

## 🚀 Começando

### Pré-requisitos

* Java JDK 17
* Maven 3.6+
* (Opcional) Postman / HTTP client

   * **Swagger UI**: `http://localhost:8080/swagger-ui.html`

---

## 🛠️ Estrutura do Projeto

```text
src/
├─ main/
│  ├─ java/com/xpinc/assessor/
│  │   ├ AssessorVirtualApplication.java
│  │   ├ config/SwaggerConfig.java
│  │   ├ controller/  # Endpoints REST
│  │   ├ dto/         # Data Transfer Objects
│  │   ├ domain/      # Modelos de domínio
│  │   ├ exception/   # Tratamento de erros
│  │   ├ service/     # Lógica de negócio (InMemory)
│  │   ├ service/strategy # Estratégias de recomendação
│  │   └ util/XAIUtil.java
│  └─ resources/
│      └ application.properties
└─ pom.xml
```

---

## 🔌 Endpoints

Base URL: `http://localhost:8080/api`

### Ativos

| Método | Rota           | Descrição                |
| ------ | -------------- | ------------------------ |
| GET    | `/ativos`      | Lista todos os ativos    |
| GET    | `/ativos/{id}` | Busca ativo por ID       |
| POST   | `/ativos`      | Cria novo ativo          |
| PUT    | `/ativos/{id}` | Atualiza ativo existente |
| DELETE | `/ativos/{id}` | Remove ativo             |

### Clientes

| Método | Rota             | Descrição                  |
| ------ | ---------------- | -------------------------- |
| GET    | `/clientes`      | Lista todos os clientes    |
| GET    | `/clientes/{id}` | Busca cliente por ID       |
| POST   | `/clientes`      | Cria novo cliente          |
| PUT    | `/clientes/{id}` | Atualiza cliente existente |
| DELETE | `/clientes/{id}` | Remove cliente             |

### Variáveis Macro

| Método | Rota                    | Descrição                         |
| ------ | ----------------------- | --------------------------------- |
| GET    | `/variaveis-macro`      | Lista variáveis macro             |
| GET    | `/variaveis-macro/{id}` | Busca variável macro por ID       |
| POST   | `/variaveis-macro`      | Cria variável macro               |
| PUT    | `/variaveis-macro/{id}` | Atualiza variável macro existente |
| DELETE | `/variaveis-macro/{id}` | Remove variável macro             |

### Recomendações

| Método | Rota             | Payload              |
| ------ | ---------------- | -------------------- |
| POST   | `/recomendacoes` | `{ "clienteId": 1 }` |

---

## 📖 Funcionamento

1. **Serviços InMemory**: usam `Map<Long, Entidade>` para CRUD.
2. **ID sequencial**: cada service gera IDs automaticamente.
3. **Estratégias** (`Conservador`, `Moderado`, `Agressivo`): implementam `RecomendacaoStrategy`.
4. **StrategyFactory**: injeta todas as estratégias e seleciona conforme perfil.
5. **XAIUtil**: gera explicação simples para alocação.
