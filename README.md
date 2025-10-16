# 🏦 AcessorXPSOA — Serviço de Assessoria (SOA + Web Services)

Sprint 4 de **Arquitetura Orientada a Serviços e Web Services** — FIAP  

---

## 👥 Alunos
- Bruno Venturi Lopes Vieira – 99431  
- Guilherme Alves de Lima – 550433  
- Pedro Guerra de Souza Freitas – 99526  
- Leonardo de Oliveira Ruiz – 98901  

---

## 👀 Visão Geral

O **AcessorXPSOA** é um sistema de **assessoria de investimentos** que:
- Gerencia **Ativos**, **Clientes** e **Variáveis Macroeconômicas**
- Gera **recomendações de carteira** conforme o perfil do investidor
- Implementa **autenticação e autorização seguras (JWT + Spring Security)**
- Segue princípios de **SOLID**, **Clean Code** e **arquitetura em camadas**
- Inclui **documentação automática** (Swagger / SpringDoc)
- Possui **testes unitários e de integração** automatizados

---

## ⚙️ Requisitos
- **JDK 17**  
- **Maven 3.9+**

---

## ▶️ Como executar
```bash
mvn clean spring-boot:run
```
Verifique no log: `Flyway ... Successfully applied ...` e sem exceções.

- H2 Console → [http://localhost:8080/h2](http://localhost:8080/h2)  
  - JDBC URL : `jdbc:h2:mem:assessor`  
  - User : `sa`  
  - Password : *(vazio)*  

---

## 🔐 Segurança e Autenticação (JWT)

A aplicação agora é **stateless**, com **Spring Security + JWT**.  
Senhas são criptografadas com **BCryptPasswordEncoder**.

### Endpoints públicos
| Método | Rota | Descrição |
|--------|------|------------|
| `POST` | `/auth/signup` | Cria um novo usuário |
| `POST` | `/auth/login`  | Autentica e retorna um token JWT |

**Exemplo de login**
```http
POST /auth/login
Content-Type: application/json

{
  "username": "admin",
  "password": "admin123"
}
```
**Resposta**
```json
{ "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6..." }
```
Use o token nas próximas requisições:
```
Authorization: Bearer <token>
```

### Perfis de acesso
| Papel | Permissões |
|-------|-------------|
| `ROLE_USER` | Consultar ativos, variáveis macro e gerar recomendações |
| `ROLE_ADMIN` | CRUD completo em todos os recursos |

---

## 🔌 Endpoints principais

| Módulo | Rota base | Papel | Descrição |
|--------|------------|--------|------------|
| **Ativos** | `/api/ativos` | USER (GET) / ADMIN (CRUD) | Gerencia ativos financeiros |
| **Clientes** | `/api/clientes` | ADMIN | CRUD de clientes |
| **Variáveis Macro** | `/api/variaveis-macro` | USER (GET) / ADMIN (CRUD) | Dados macroeconômicos |
| **Recomendações** | `/api/recomendacoes` | USER | Gera carteira personalizada |

---

## 📡 Exemplos de requisições

### Criar Ativo
```http
POST /api/ativos
Authorization: Bearer <token>
Content-Type: application/json

{
  "nome":"ETF BOVA11",
  "classe":"RENDA_VARIAVEL",
  "retornoHistorico":10.2,
  "liquidezDias":2
}
```

### Gerar Recomendação
```http
POST /api/recomendacoes
Authorization: Bearer <token>

{
  "clienteId": 1
}
```
**200 OK**
```json
{
  "risco":"MODERADO",
  "alocacao":[
    {"classe":"RENDA_FIXA","percentual":50.0},
    {"classe":"RENDA_VARIAVEL","percentual":25.0},
    {"classe":"MULTIMERCADO","percentual":15.0},
    {"classe":"CAMBIAL","percentual":10.0}
  ],
  "explicacao":"..."
}
```

---

## 🧱 Tecnologias
- **Java 17**
- **Spring Boot 3.1.12**
  - Web, Data JPA, Validation, Security
- **H2 Database** + **Flyway**
- **JWT (JJWT 0.11.5)** + **BCrypt**
- **SpringDoc OpenAPI 3** / **Swagger UI**
- **JUnit 5 + Mockito**

---

## 🧰 Estrutura do Projeto
```
acessor-SOA/
├── controller/        # Endpoints REST
├── service/           # Regras de negócio (Strategy)
├── repository/        # Spring Data JPA
├── domain/            # Entidades e Enums
├── dto/ & mapper/     # Transporte e mapeamento
├── config/            # Segurança e OpenAPI
├── exception/         # Tratamento global de erros
└── resources/db/migration/ # Scripts Flyway (V1 – V5)
```

---

## 🧪 Testes Automatizados

### Unitários
- `RecomendacaoServiceTest` → valida uso do StrategyFactory  
- `JwtServiceTest` → gera e valida tokens JWT  

### Integração
- `AuthIntegrationTest` → testa login e acesso a rotas protegidas  

**Executar**
```bash
mvn test
```

---

## 📄 Documentação (OpenAPI + Swagger)

- Documentação automática via **SpringDoc OpenAPI 3**
- Esquema de segurança JWT (`bearerAuth`)
- URL: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
- Clique em **Authorize 🔒** e cole seu token JWT  

---

## ✅ Boas Práticas Implementadas

| Conceito | Aplicação |
|-----------|-----------|
| **SOLID** | Camadas bem definidas e uso de interfaces |
| **Polimorfismo** | Estratégias de recomendação (Conservador, Moderado, Arrojado) |
| **Injeção de Dependência** | Via Spring Context (`@Service`, `@Repository`) |
| **Validação** | `jakarta.validation` em DTOs |
| **Criptografia** | Senhas com `BCryptPasswordEncoder` |
| **JWT Stateless** | Autenticação sem sessão |
| **Flyway** | Versionamento do banco de dados |
| **Tratamento Global de Erros** | `GlobalExceptionHandler` padronizado |
| **Testabilidade** | Testes unitários e de integração com Mockito |

---

## 🧭 Execução Rápida

| Ação | Comando / URL |
|------|----------------|
| Subir aplicação | `mvn spring-boot:run` |
| Banco em memória | `http://localhost:8080/h2` |
| Swagger UI | `http://localhost:8080/swagger-ui.html` |
| Criar usuário | `POST /auth/signup` |
| Login JWT | `POST /auth/login` |
| Executar testes | `mvn test` |

---
